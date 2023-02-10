package com.ninjaone.shared.infrastructure.hibernate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.internal.util.ReflectHelper;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class JsonType implements UserType, ParameterizedType, Serializable {

    private static final long serialVersionUID = 1L;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final String CLASS_TYPE = "classType";
    private static final String TYPE = "type";

    private static final int[] SQL_TYPES = new int[] { Types.LONGVARCHAR, Types.CLOB, Types.BLOB };

    private Class<?> classType;
    private int sqlType = Types.LONGVARCHAR; // before any guessing

    @Override
    public void setParameterValues(Properties params) {
        String classTypeName = params.getProperty(CLASS_TYPE);
        try {
            this.classType = ReflectHelper.classForName(classTypeName, this.getClass());
        } catch (ClassNotFoundException cnfe) {
            throw new HibernateException("classType not found", cnfe);
        }
        String type = params.getProperty(TYPE);
        if (type != null) {
            this.sqlType = Integer.decode(type).intValue();
        }

    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return this.deepCopy(cached);
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        Object copy = null;
        if (value != null) {

            try {
                return MAPPER.readValue(MAPPER.writeValueAsString(value), this.classType);
            } catch (IOException e) {
                throw new HibernateException("unable to deep copy object", e);
            }
        }
        return copy;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new HibernateException("unable to disassemble object", e);
        }
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equal(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner) throws SQLException {
        Object obj = null;
        if (this.sqlType == Types.CLOB || this.sqlType == Types.BLOB) {
            byte[] bytes = rs.getBytes(position);
            if (bytes != null && !rs.wasNull()) {
                try {
                    obj = MAPPER.readValue(bytes, this.classType);
                } catch (IOException e) {
                    throw new HibernateException("unable to read object from result set", e);
                }
            }
        } else {
            try {
                String content = rs.getString(position);
                if (content != null && !rs.wasNull()) {
                    obj = MAPPER.readValue(content, this.classType);
                }
            } catch (IOException e) {
                throw new HibernateException("unable to read object from result set", e);
            }
        }
        return obj;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws SQLException {
        if (value == null) {
            st.setNull(index, this.sqlType);
        } else {

            if (this.sqlType == Types.CLOB || this.sqlType == Types.BLOB) {
                try {
                    st.setBytes(index, MAPPER.writeValueAsBytes(value));
                } catch (JsonProcessingException e) {
                    throw new HibernateException("unable to set object to result set", e);
                }
            } else {
                try {
                    st.setString(index, MAPPER.writeValueAsString(value));
                } catch (JsonProcessingException e) {
                    throw new HibernateException("unable to set object to result set", e);
                }
            }
        }
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return this.deepCopy(original);
    }

    @Override
    public int getSqlType() {
        return Types.LONGVARCHAR;
    }

    @Override
    public Class<?> returnedClass() {
        return this.classType;
    }
}
