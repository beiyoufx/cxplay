package com.tgg.cxplay.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.tgg.cxplay.dao.AreaDao;
import com.tgg.cxplay.dao.util.CustomSQLUtil;
import com.tgg.cxplay.dao.util.QueryPos;
import com.tgg.cxplay.dao.util.SQLConstants;
import com.tgg.cxplay.model.Area;

public class AreaDaoImpl extends BaseDao implements AreaDao {
    
    private final String FIND_ALL = AreaDao.class.getName() + ".findAll";
    private final String FIND = AreaDao.class.getName() + ".findAreasByKeywords";
    private final String GET_AREA_BY_ID = AreaDao.class.getName() + ".getAreaById";
    private final String GET_AREA_BY_NAME = AreaDao.class.getName() + ".getAreaByName";
    private final String SAVE_AREA = AreaDao.class.getName() + ".saveArea";
    private final String UPDATE_AREA = AreaDao.class.getName() + ".updateArea";
    private final String DELETE_AREA_BY_ID = AreaDao.class.getName() + ".deleteAreaById";
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Area> find() {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(FIND_ALL);
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Area.class);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Area> find(String keywords) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(FIND);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(keywords);
        
        query.addEntity(Area.class);
        return query.list();
    }

    @Override
    public Area getArea(int id) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(GET_AREA_BY_ID);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(id);
        
        query.addEntity(Area.class);
        return (Area) query.uniqueResult();
    }

    @Override
    public Area getArea(String name) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(GET_AREA_BY_NAME);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(name);
        
        query.addEntity(Area.class);
        return (Area) query.uniqueResult();
    }

    @Override
    public int save(Area area) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(SAVE_AREA);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(area.getName());
        qPos.add(area.getDisplayName());
        
        query.executeUpdate();
        
        sql = CustomSQLUtil.get(SQLConstants.LAST_INSERT_ID);
        query = session.createSQLQuery(sql);
        
        return ((BigInteger)query.uniqueResult()).intValue();
    }

    @Override
    public int update(Area area) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(UPDATE_AREA);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(area.getDisplayName());
        
        return query.executeUpdate();
    }

    @Override
    public int delete(int id) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(DELETE_AREA_BY_ID);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(id);
        
        return query.executeUpdate();
    }

}
