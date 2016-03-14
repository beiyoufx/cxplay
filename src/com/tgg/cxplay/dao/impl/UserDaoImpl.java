package com.tgg.cxplay.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.tgg.cxplay.dao.UserDao;
import com.tgg.cxplay.dao.util.CustomSQLUtil;
import com.tgg.cxplay.dao.util.QueryPos;
import com.tgg.cxplay.dao.util.SQLConstants;
import com.tgg.cxplay.model.Role;
import com.tgg.cxplay.model.User;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;
import com.tgg.cxplay.util.StringUtil;

/** 
 * @ClassName UserDaoImpl
 * @Description Implements methods for user CIUD.
 * @author Jerry Teng
 * @date Jul 7, 2015 10:45:22 PM
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    
    private final String GET_USER = UserDao.class.getName() + ".getUser";
    private final String GET_USER_BY_ID = UserDao.class.getName() + ".getUserById";
    private final String FIND = UserDao.class.getName() + ".findAll";
    private final String FIND_BASE = UserDao.class.getName() + ".findBase";
    private final String DELETE_USER_BY_ID = UserDao.class.getName() + ".deleteUserById";
    private final String COUNT_BASE = UserDao.class.getName() + ".countBase";
    private final String SAVE_USER = UserDao.class.getName() + ".saveUser";
    private final String UPDATE_USER = UserDao.class.getName() + ".updateUser";
    private final String UPDATE_USER_ROLE = UserDao.class.getName() + ".updateUserRole";
    private final String GET_ROLE = UserDao.class.getName() + ".getRole";

    @SuppressWarnings("unchecked")
    @Override
    public List<User> find() {

        Session session = getSession();
        String sql = CustomSQLUtil.get(FIND);
        sql = initSQLForAsset(sql);
        SQLQuery query = session.createSQLQuery(sql);
        
        query.setResultTransformer(Transformers.aliasToBean(User.class));
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> find(Role role, String keywords, LimitCriteriaVO limitCriteriaVO) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(FIND_BASE);
        sql = initSQLForAsset(sql);
        StringBuffer sb = new StringBuffer(sql);
        
        int totalItems = count(role, keywords);
        limitCriteriaVO.setTotalItems(totalItems);
        if (limitCriteriaVO.getIndex() - 1 > totalItems) {
            limitCriteriaVO.setCurrentPage((totalItems - 1) / limitCriteriaVO.getPerPageItems() + 1);
        }
        
        if (role != null) {
            sb.append(CustomSQLUtil.get(SQLConstants.AND_ROLE_CRITERIA));
        }
        if (StringUtil.isNotEmpty(keywords)) {
            sb.append(CustomSQLUtil.get(SQLConstants.AND_USER_KEYWORDS_CRITERIA));
        }
        if (StringUtil.isNotEmpty(limitCriteriaVO.getOrderBy())) {
            sb.append(CustomSQLUtil.get(SQLConstants.ORDER));
        } else {
            sb.append(CustomSQLUtil.getDefaultOrder());
        }
        sb.append(CustomSQLUtil.get(SQLConstants.LIMIT));
        sql = sb.toString();
        
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        if (role != null) {
            qPos.add(role.getId());
        }
        if (StringUtil.isNotEmpty(keywords)) {
            qPos.add(keywords);
        }
        qPos.add(limitCriteriaVO.getIndex() - 1);
        qPos.add(limitCriteriaVO.getPerPageItems());
        if (StringUtil.isNotEmpty(limitCriteriaVO.getOrderBy())) {
            qPos.add(limitCriteriaVO.getOrderBy());
            qPos.add(limitCriteriaVO.isDESC());
        }
        
        query.setResultTransformer(Transformers.aliasToBean(User.class));
        return query.list();
    }

    @Override
    public List<User> find(Role role, LimitCriteriaVO limitCriteriaVO) {
        return find(role, null, limitCriteriaVO);
    }

    @Override
    public List<User> find(String keywords, LimitCriteriaVO limitCriteriaVO) {
        return find(null, keywords, limitCriteriaVO);
    }

    @Override
    public User getUser(int id) {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(GET_USER_BY_ID);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(id);
        
        query.setResultTransformer(Transformers.aliasToBean(User.class));
        
        return (User) query.uniqueResult();
    }

    @Override
    public User getUser(String username) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(GET_USER);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(username);
        
        query.setResultTransformer(Transformers.aliasToBean(User.class));
        
        return (User) query.uniqueResult();
    }
    
    @Override
    public int save(User user) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(SAVE_USER);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(user.getName());
        qPos.add(user.getPassword());
        qPos.add(user.getDisplayName());
        
        sql = CustomSQLUtil.get(SQLConstants.LAST_INSERT_ID);
        query = session.createSQLQuery(sql);
        return ((BigInteger)query.uniqueResult()).intValue();
    }

    @Override
    public int update(User user) {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(UPDATE_USER);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(user.getName());
        qPos.add(user.getPassword());
        qPos.add(user.getDisplayName());
        
        return query.executeUpdate();
    }

    @Override
    public int delete(int id) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(DELETE_USER_BY_ID);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(id);
        
        return query.executeUpdate();
    }

    @Override
    public int count(Role role, String keywords) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(COUNT_BASE);
        
        sql = initSQLForAsset(sql);
        StringBuffer sb = new StringBuffer(sql);
        if (role != null) {
            sb.append(CustomSQLUtil.get(SQLConstants.AND_ROLE_CRITERIA));
        }
        if (StringUtil.isNotEmpty(keywords)) {
            sb.append(CustomSQLUtil.get(SQLConstants.AND_USER_KEYWORDS_CRITERIA));
        }
        sql = sb.toString();
        
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        if (role != null) {
            qPos.add(role.getId());
        }
        if (StringUtil.isNotEmpty(keywords)) {
            qPos.add(keywords);
        }
        return ((BigInteger)query.uniqueResult()).intValue();
    }

    @Override
    public void update_U_R(int userId, String roleName) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(GET_ROLE);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(roleName);
        
        int roleId = ((BigInteger)query.uniqueResult()).intValue();
        
        sql = CustomSQLUtil.get(UPDATE_USER_ROLE);
        query = session.createSQLQuery(sql);
        qPos = QueryPos.getInstance(query);
        
        qPos.add(userId);
        qPos.add(roleId);
        
        query.executeUpdate();
    }
    
    private String initSQLForAsset(String sql) {
        sql = sql.replace("[$ADD_RESAULT_ROLE$]", CustomSQLUtil.get("ADD_RESAULT_ROLE"));
        sql = sql.replace("[$LEFT_TABLE_ROLE$]", CustomSQLUtil.get("LEFT_TABLE_ROLE"));
        return sql;
    }

}
