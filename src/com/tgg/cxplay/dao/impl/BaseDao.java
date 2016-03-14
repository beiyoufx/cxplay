package com.tgg.cxplay.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public void close(Session session) {
        if (session != null) {
            session.close();
        }
    }
    public void clear(Session session) {
        if (session != null) {
            session.clear();
        }
    }
}
