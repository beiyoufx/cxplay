package com.tgg.cxplay.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.tgg.cxplay.dao.CategoryDao;
import com.tgg.cxplay.dao.util.CustomSQLUtil;
import com.tgg.cxplay.dao.util.QueryPos;
import com.tgg.cxplay.dao.util.SQLConstants;
import com.tgg.cxplay.model.Category;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

    private final String FIND_ALL = CategoryDao.class.getName() + ".findAll";
    private final String FIND = CategoryDao.class.getName() + ".findCategoriesByKeywords";
    private final String GET_CATEGORY_BY_ID = CategoryDao.class.getName() + ".getCategoryById";
    private final String GET_CATEGORY_BY_NAME = CategoryDao.class.getName() + ".getCategoryByName";
    private final String SAVE_CATEGORY = CategoryDao.class.getName() + ".saveCategory";
    private final String UPDATE_CATEGORY = CategoryDao.class.getName() + ".updateCategory";
    private final String DELETE_CATEGORY_BY_ID = CategoryDao.class.getName() + ".deleteCategoryById";
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Category> find() {

        Session session = getSession();
        String sql = CustomSQLUtil.get(FIND_ALL);
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Category.class);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> find(String keywords) {
        Session session = getSession();
        String sql = CustomSQLUtil.get(FIND);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(keywords);
        
        query.addEntity(Category.class);
        return query.list();
    }

    @Override
    public Category getCategory(int id) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(GET_CATEGORY_BY_ID);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(id);
        
        query.addEntity(Category.class);
        return (Category) query.uniqueResult();
    }

    @Override
    public Category getCategory(String name) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(GET_CATEGORY_BY_NAME);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(name);
        
        query.addEntity(Category.class);
        return (Category) query.uniqueResult();
    }

    @Override
    public int save(Category Category) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(SAVE_CATEGORY);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(Category.getName());
        qPos.add(Category.getDisplayName());
        
        query.executeUpdate();
        
        sql = CustomSQLUtil.get(SQLConstants.LAST_INSERT_ID);
        query = session.createSQLQuery(sql);
        
        return ((BigInteger)query.uniqueResult()).intValue();
    }

    @Override
    public int update(Category category) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(UPDATE_CATEGORY);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(category.getDisplayName());
        
        return query.executeUpdate();
    }

    @Override
    public int delete(int id) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(DELETE_CATEGORY_BY_ID);
        SQLQuery query = session.createSQLQuery(sql);
        
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(id);
        
        return query.executeUpdate();
    }

}
