package com.tgg.cxplay.service;

import java.util.List;

import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.model.User;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;

public interface UserService {

	public User getUser(String username, String password) throws ParamException;
	public List<User> find();
	public List<User> find(String keywords, LimitCriteriaVO limitCriteriaVO) throws ParamException;
	public User getUser(int id) throws ParamException;
    public List<User> find(int[] ids) throws ParamException;
    public int save(User user) throws ParamException;
    public void save(List<User> users) throws ParamException;
    public boolean update(User user);
    public boolean delete(int id);
    public boolean delete(int[] ids);
}
