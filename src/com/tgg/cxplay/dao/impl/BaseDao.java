package com.tgg.cxplay.dao.impl;

import org.hibernate.Session;

public class BaseDao {

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
