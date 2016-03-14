package com.tgg.cxplay.dao;

import java.util.List;

import com.tgg.cxplay.model.Role;
import com.tgg.cxplay.model.User;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;

/** 
 * @ClassName UserDao
 * @Description Definition methods for user CRUD.
 * @author Jerry Teng
 * @date 2015/7/7 22:45:22
 */
public interface UserDao {
    public List<User> find();
    public List<User> find(Role role, String keywords, LimitCriteriaVO limitCriteriaVO);
    public List<User> find(Role role, LimitCriteriaVO limitCriteriaVO);
    public List<User> find(String keywords, LimitCriteriaVO limitCriteriaVO);
    public User getUser(int id);
    public User getUser(String username);
    public int count(Role role, String keywords);
    public int save(User user);
    public int update(User user);
    public void update_U_R(int userId, String roleName);
    public int delete(int id);
}
