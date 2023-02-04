package com.ninjaone.shared.infrastructure.hibernate;

import org.hibernate.SessionFactory;

public class HibernateRepository<T> {
    protected final SessionFactory sessionFactory;
    protected final Class<T> aggregateClass;

    public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
    }

    protected void persist(T entity) {
        sessionFactory.getCurrentSession().persist(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
}
