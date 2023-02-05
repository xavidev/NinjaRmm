package com.ninjaone.shared.infrastructure.hibernate;

import com.ninjaone.shared.domain.Identifier;
import com.ninjaone.shared.domain.criteria.Criteria;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class HibernateRepository<T> {
    protected final SessionFactory sessionFactory;
    protected final Class<T> aggregateClass;

    protected final HibernateCriteriaConverter<T> criteriaConverter;

    public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
        criteriaConverter = new HibernateCriteriaConverter<T>(sessionFactory.getCriteriaBuilder());
    }

    protected void persist(T entity) {
        sessionFactory.getCurrentSession().merge(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    protected Optional<T> byId(Identifier id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    protected List<T> byCriteria(Criteria criteria) {
        CriteriaQuery<T> hibernateCriteria = criteriaConverter.convert(criteria, aggregateClass);

        return sessionFactory.getCurrentSession().createQuery(hibernateCriteria).getResultList();
    }
}
