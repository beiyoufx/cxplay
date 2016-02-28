package com.tgg.cxplay.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.tgg.cxplay.dao.UserDao;
import com.tgg.cxplay.model.Role;
import com.tgg.cxplay.model.User;
import com.tgg.cxplay.model.Video;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;

/** 
 * @ClassName UserDaoImpl
 * @Description Implements methods for user CRUD.
 * @author Jerry Teng
 * @date Jul 7, 2015 10:45:22 PM
 */
public class UserDaoImpl implements UserDao {
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> find() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Video> find(int[] ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Video> find(Role role, String keywords,
            LimitCriteriaVO limitCriteriaVO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Video> find(Role role) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Video> find(String keywords) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUser(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void save(List<User> users) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(int[] ids) {
        // TODO Auto-generated method stub
        
    }

}
