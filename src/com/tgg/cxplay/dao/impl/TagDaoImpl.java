package com.tgg.cxplay.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.tgg.cxplay.dao.TagDao;
import com.tgg.cxplay.dao.util.CustomSQLUtil;
import com.tgg.cxplay.dao.util.QueryPos;
import com.tgg.cxplay.dao.util.SQLConstants;
import com.tgg.cxplay.model.Tag;

public class TagDaoImpl extends BaseDao implements TagDao {
    
    private final String FIND_ALL = TagDao.class.getName() + ".findAll";
    private final String FIND = TagDao.class.getName() + ".findTagsByKeywords";
    private final String GET_TAG_BY_ID = TagDao.class.getName() + ".getTagById";
    private final String GET_TAG_BY_NAME = TagDao.class.getName() + ".getTagByName";
    private final String SAVE_TAG = TagDao.class.getName() + ".saveTag";
    private final String UPDATE_TAG = TagDao.class.getName() + ".updateTag";
    private final String DELETE_TAG_BY_ID = TagDao.class.getName() + ".deleteTagById";

    @SuppressWarnings("unchecked")
    @Override
    public List<Tag> find() {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(FIND_ALL);
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Tag.class);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tag> find(String keywords) {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(FIND);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(keywords);
        
        query.addEntity(Tag.class);
        return query.list();
    }

    @Override
    public Tag getTag(int id) {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(GET_TAG_BY_ID);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(id);
        
        query.addEntity(Tag.class);
        return (Tag) query.uniqueResult();
    }

    @Override
    public Tag getTag(String name) {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(GET_TAG_BY_NAME);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(name);
        
        query.addEntity(Tag.class);
        return (Tag) query.uniqueResult();
    }

    @Override
    public int save(Tag tag) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(SAVE_TAG);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(tag.getName());
        qPos.add(tag.getDisplayName());
        
        query.executeUpdate();
        
        sql = CustomSQLUtil.get(SQLConstants.LAST_INSERT_ID);
        query = session.createSQLQuery(sql);
        
        return ((BigInteger)query.uniqueResult()).intValue();
    }

    @Override
    public int update(Tag tag) {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(UPDATE_TAG);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(tag.getDisplayName());
        
        return query.executeUpdate();
    }

    @Override
    public int delete(int id) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(DELETE_TAG_BY_ID);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(id);
        
        return query.executeUpdate();
    }

}
