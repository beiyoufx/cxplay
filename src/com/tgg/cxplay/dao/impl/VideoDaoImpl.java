package com.tgg.cxplay.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.tgg.cxplay.dao.VideoDao;
import com.tgg.cxplay.dao.util.CustomSQLUtil;
import com.tgg.cxplay.dao.util.QueryPos;
import com.tgg.cxplay.dao.util.SQLConstants;
import com.tgg.cxplay.model.Area;
import com.tgg.cxplay.model.Category;
import com.tgg.cxplay.model.Tag;
import com.tgg.cxplay.model.Video;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;
import com.tgg.cxplay.model.vo.VideoVO;
import com.tgg.cxplay.util.StringUtil;

/** 
 * @ClassName VideoDaoImpl
 * @Description Implements methods for video CIUD.
 * @author Jerry Teng
 * @date Jul 7, 2015 10:45:22 PM
 *
 */
@SuppressWarnings("unchecked")
public class VideoDaoImpl extends BaseDao implements VideoDao {

    private final String COUNT_BASE = VideoDao.class.getName() + ".countBase";
    private final String FIND_BASE = VideoDao.class.getName() + ".findBase";
    private final String FIND = VideoDao.class.getName() + ".findAll";
    private final String GET_VIDEO_BY_ID = VideoDao.class.getName() + ".getVideoById";
    private final String SAVE_VIDEO = VideoDao.class.getName() + ".saveVideo";
    private final String UPDATE_VIDEO = VideoDao.class.getName() + ".updateVideo";
    private final String DELETE_VIDEO_BY_ID = VideoDao.class.getName() + ".deleteVideoById";
    private final String UPDATE_VIDEO_TAG = VideoDao.class.getName() + ".updateVideoTag";
    private final String UPDATE_VIDEO_AREA = VideoDao.class.getName() + ".updateVideoArea";
    private final String UPDATE_VIDEO_CATEGORY = VideoDao.class.getName() + ".updateVideoCategory";

    @Override
    public List<Video> find() {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(FIND);
        sql = initSQLForAsset(sql);
        SQLQuery query = session.createSQLQuery(sql);
        
        query.setResultTransformer(Transformers.aliasToBean(Video.class));
        return query.list();
    }

    @Override
    public List<Video> find(Area area, Tag tag, Category category,
            String keywords, LimitCriteriaVO limitCriteriaVO) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(FIND_BASE);
        sql = initSQLForAsset(sql);
        StringBuffer sb = new StringBuffer(sql);
        
        int totalItems = count(area, tag, category, keywords);
        limitCriteriaVO.setTotalItems(totalItems);
        if (limitCriteriaVO.getIndex() - 1 > totalItems) {
            limitCriteriaVO.setCurrentPage((totalItems - 1) / limitCriteriaVO.getPerPageItems() + 1);
        }
        
        if (area != null) {
            sb.append(CustomSQLUtil.get(SQLConstants.AND_AREA_CRITERIA));
        }
        if (tag != null) {
            sb.append(CustomSQLUtil.get(SQLConstants.AND_TAG_CRITERIA));
        }
        if (category != null) {
            sb.append(CustomSQLUtil.get(SQLConstants.AND_CATEGORY_CRITERIA));
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
        
        if (area != null) {
            qPos.add(area.getName());
        }
        if (tag != null) {
            qPos.add(tag.getName());
        }
        if (category != null) {
            qPos.add(category.getName());
        }
        qPos.add(limitCriteriaVO.getIndex() - 1);
        qPos.add(limitCriteriaVO.getPerPageItems());
        if (StringUtil.isNotEmpty(limitCriteriaVO.getOrderBy())) {
            qPos.add(limitCriteriaVO.getOrderBy());
            qPos.add(limitCriteriaVO.isDESC());
        }
        
        query.setResultTransformer(Transformers.aliasToBean(Video.class));
        return query.list();
    }

    @Override
    public List<Video> find(Area area, LimitCriteriaVO limitCriteriaVO) {
        return find(area, null, null, null, limitCriteriaVO);
    }

    @Override
    public List<Video> find(Tag tag, LimitCriteriaVO limitCriteriaVO) {
        return find(null, tag, null, null, limitCriteriaVO);
    }

    @Override
    public List<Video> find(String keywords, LimitCriteriaVO limitCriteriaVO) {
        return find(null, null, null, keywords, limitCriteriaVO);
    }

    @Override
    public List<Video> find(Category category, LimitCriteriaVO limitCriteriaVO) {
        return find(null, null, category, null, limitCriteriaVO);
    }

    @Override
    public int count(Area area, Tag tag, Category category, String keywords) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(COUNT_BASE);
        
        sql = initSQLForAsset(sql);
        StringBuffer sb = new StringBuffer(sql);
        if (area != null) {
            sb.append(CustomSQLUtil.get(SQLConstants.AND_AREA_CRITERIA));
        }
        if (tag != null) {
            sb.append(CustomSQLUtil.get(SQLConstants.AND_TAG_CRITERIA));
        }
        if (category != null) {
            sb.append(CustomSQLUtil.get(SQLConstants.AND_CATEGORY_CRITERIA));
        }
        sql = sb.toString();
        
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        if (area != null) {
            qPos.add(area.getName());
        }
        if (tag != null) {
            qPos.add(tag.getName());
        }
        if (category != null) {
            qPos.add(category.getName());
        }
        return ((BigInteger)query.uniqueResult()).intValue();
    }

    @Override
    public Video getVideo(int id) {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(GET_VIDEO_BY_ID);
        sql = initSQLForAsset(sql);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(id);
        
        query.setResultTransformer(Transformers.aliasToBean(Video.class));
        return (Video) query.uniqueResult();
    }

    @Override
    public int save(VideoVO videoVO) {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(SAVE_VIDEO);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(videoVO.getName());
        qPos.add(videoVO.getEnName());
        qPos.add(videoVO.getUrl());
        qPos.add(videoVO.getPic());
        qPos.add(videoVO.getClarity());
        qPos.add(videoVO.getSynopsis());
        qPos.add(videoVO.getEpisode());
        qPos.add(videoVO.getActors());
        qPos.add(videoVO.getDirectors());
        query.executeUpdate();
        
        sql = CustomSQLUtil.get(SQLConstants.LAST_INSERT_ID);
        query = session.createSQLQuery(sql);
        return ((BigInteger)query.uniqueResult()).intValue();
    }

    @Override
    public int update(VideoVO videoVO) {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(UPDATE_VIDEO);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(videoVO.getName());
        qPos.add(videoVO.getEnName());
        qPos.add(videoVO.getUrl());
        qPos.add(videoVO.getPic());
        qPos.add(videoVO.getClarity());
        qPos.add(videoVO.getSynopsis());
        qPos.add(videoVO.getEpisode());
        qPos.add(videoVO.getActors());
        qPos.add(videoVO.getDirectors());
        qPos.add(videoVO.getId());
        
        return query.executeUpdate();
    }

    @Override
    public int delete(int id) {
        
        Session session = getSession();
        String sql = CustomSQLUtil.get(DELETE_VIDEO_BY_ID);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(id);
        
        return query.executeUpdate();
    }

    @Override
    public void update_V_A(int videoId, int areaId) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(UPDATE_VIDEO_AREA);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(videoId);
        qPos.add(areaId);
        
        query.executeUpdate();
    }

    @Override
    public void update_V_T(int videoId, int TagId) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(UPDATE_VIDEO_TAG);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(videoId);
        qPos.add(TagId);
        
        query.executeUpdate();
    }

    @Override
    public void update_V_C(int videoId, int CategoryId) {

        Session session = getSession();
        String sql = CustomSQLUtil.get(UPDATE_VIDEO_CATEGORY);
        SQLQuery query = session.createSQLQuery(sql);
        QueryPos qPos = QueryPos.getInstance(query);
        
        qPos.add(videoId);
        qPos.add(CategoryId);
        
        query.executeUpdate();
    }
    
    private String initSQLForAsset(String sql) {
        sql = sql.replace("[$ADD_RESAULT_CATEGORY$]", CustomSQLUtil.get("ADD_RESAULT_CATEGORY"));
        sql = sql.replace("[$ADD_RESAULT_AREA$]", CustomSQLUtil.get("ADD_RESAULT_AREA"));
        sql = sql.replace("[$ADD_RESAULT_TAG$]", CustomSQLUtil.get("ADD_RESAULT_TAG"));
        sql = sql.replace("[$LEFT_TABLE_CATEGORY$]", CustomSQLUtil.get("LEFT_TABLE_CATEGORY"));
        sql = sql.replace("[$LEFT_TABLE_AREA$]", CustomSQLUtil.get("LEFT_TABLE_AREA"));
        sql = sql.replace("[$LEFT_TABLE_TAG$]", CustomSQLUtil.get("LEFT_TABLE_TAG"));
        return sql;
    }
    
}
