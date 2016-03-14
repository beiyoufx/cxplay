package com.tgg.cxplay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tgg.cxplay.dao.UserDao;
import com.tgg.cxplay.exception.EparamError;
import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.log.Log;
import com.tgg.cxplay.log.LogFactoryUtil;
import com.tgg.cxplay.model.User;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;
import com.tgg.cxplay.service.UserService;
import com.tgg.cxplay.util.StringUtil;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
	@Override
	public User getUser(String username, String password) throws ParamException {
		
		ParamException pe = null;
		if (StringUtil.isEmpty(username)) {
			pe = new ParamException(EparamError.USER_NAME_NULL, "Username is required");
			throw pe;
		}
		if (StringUtil.isEmpty(password)) {
			pe = new ParamException(EparamError.USER_PASSWORD_NULL, "Password is required");
			throw pe;
		}
		User user = userDao.getUser(username);
		if (user == null) {
			pe = new ParamException(EparamError.USER_NOT_EXIST, "User not exist");
			throw pe;
		}
		if (!password.equals(user.getPassword())) {
			pe = new ParamException(EparamError.USER_PASSWORD_NOT_MATCH, "Username and password do not match");
			throw pe;
		}
		return user;
	}

	@Override
	public List<User> find() {
		return userDao.find();
	}

	@Override
	public List<User> find(String keywords, LimitCriteriaVO limitCriteriaVO)
			throws ParamException {
		
		ParamException pe = null;
		if (StringUtil.isEmpty(keywords)) {
			pe = new ParamException(EparamError.USER_KEYWORDS_NULL, "keywords is required");
			throw pe;
		}
		return userDao.find(keywords, limitCriteriaVO);
	}

	@Override
	public User getUser(int id) throws ParamException {

		ParamException pe = null;
		if (id == 0) {
			pe = new ParamException(EparamError.USER_ID_NULL, "User ID is required");
			throw pe;
		}
		return userDao.getUser(id);
	}

	@Override
	public List<User> find(int[] ids) throws ParamException {

		List<User> users = new ArrayList<User>();
    	for (int id : ids) {
    		User tempAsset = getUser(id);
    		if (tempAsset != null) {
    			users.add(tempAsset);
    		}
    	}
		return users;
	}

	@Override
	public int save(User user) throws ParamException {

		ParamException pe = null;
		if (user == null) {
			pe = new ParamException(EparamError.USER_NULL, "User is required");
			throw pe;
		}
		if (StringUtil.isEmpty(user.getName())) {
			pe = new ParamException(EparamError.USER_NAME_NULL, "Username is required");
			throw pe;
		}
		if (StringUtil.isEmpty(user.getPassword())) {
			pe = new ParamException(EparamError.USER_PASSWORD_NULL, "Password is required");
			throw pe;
		}
		if (StringUtil.isEmpty(user.getDisplayName())) {
			pe = new ParamException(EparamError.USER_KEYWORDS_NULL, "Display name is required");
			throw pe;
		}
		if (StringUtil.isEmpty(user.getRole())) {
			pe = new ParamException(EparamError.USER_ROLE_NULL, "User role is required");
			throw pe;
		}
		int id = userDao.save(user);
		
		userDao.update_U_R(id, user.getRole());
		
		return id;
	}

	@Override
	public void save(List<User> users) throws ParamException {

		for (User user : users) {
			save(user);
		}
	}

	@Override
	public boolean update(User user) {
		
		int status = userDao.update(user);
		if (status == 0) {
			log.error("Update User Error: Cannot update the user, [id:" + user.getId() + "]");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {

		int status = userDao.delete(id);
		if (status == 0) {
			log.error("Delete User Error: Cannot delete the user, [id:" + id + "]");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int[] ids) {
		
		boolean status = true;
		for (int id : ids) {
			status = delete(id);
		}
		return status;
	}

	private static final Log log = LogFactoryUtil.getLog(UserService.class);
}
