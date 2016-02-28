package com.tgg.cxplay.dao;

import java.util.List;

import com.tgg.cxplay.model.Role;
import com.tgg.cxplay.model.User;
import com.tgg.cxplay.model.Video;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;

/** 
 * @ClassName UserDao
 * @Description Definition methods for user CRUD.
 * @author Jerry Teng
 * @date 2015/7/7 22:45:22
 */
public interface UserDao {
    public List<User> find();
    public List<Video> find(int[] ids);
    public List<Video> find(Role role, String keywords, LimitCriteriaVO limitCriteriaVO);
    public List<Video> find(Role role);
    public List<Video> find(String keywords);
    public User getUser(int id);
    public void save(User user);
    public void save(List<User> users);
    public void update(User user);
    public void delete(int id);
    public void delete(int[] ids);
}
