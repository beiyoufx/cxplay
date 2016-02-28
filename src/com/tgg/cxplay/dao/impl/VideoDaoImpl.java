package com.tgg.cxplay.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tgg.cxplay.dao.VideoDao;
import com.tgg.cxplay.dao.utils.CustomSQLUtil;
import com.tgg.cxplay.dao.utils.SQLConstants;
import com.tgg.cxplay.log.Log;
import com.tgg.cxplay.log.LogFactoryUtil;
import com.tgg.cxplay.model.Area;
import com.tgg.cxplay.model.Category;
import com.tgg.cxplay.model.Tag;
import com.tgg.cxplay.model.Video;
import com.tgg.cxplay.model.VideoAsset;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;
import com.tgg.cxplay.utils.StringUtil;

/** 
 * @ClassName VideoDaoImpl
 * @Description Implements methods for video CRUD.
 * @author Jerry Teng
 * @date Jul 7, 2015 10:45:22 PM
 *
 */
public class VideoDaoImpl extends BaseDao implements VideoDao {

    private final String COUNT_BASE = VideoDao.class.getName() + ".countBase";
    private final String FIND_BASE = VideoDao.class.getName() + ".findBase";
    private final String FIND = VideoDao.class.getName() + ".findVideos";
    private final String GET_VIDEO_BY_ID = VideoDao.class.getName() + ".getVideoById";
    private final String SAVE_VIDEO = VideoDao.class.getName() + ".saveVideo";
    private final String SAVE_VIDEOS = VideoDao.class.getName() + ".saveVideos";
    private final String UPDATE_VIDEO = VideoDao.class.getName() + ".updateVideo";
    private final String DELETE_VIDEO_BY_ID = VideoDao.class.getName() + ".deleteVideoById";
    private final String DELETE_VIDEOS = VideoDao.class.getName() + ".deleteVideos";

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<?> find() {

        List<?> assets = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            String sql = CustomSQLUtil.get(FIND_BASE);
            sql = initSQLForAsset(sql);
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(VideoAsset.class);
            assets = query.list();
        } catch (Exception e) {
            log.error(e);
        } finally {
             close(session);
        }
        return assets;
    }

    @Override
    public List<?> find(int[] ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> find(Area area, Tag tag, Category category,
            String keywords, LimitCriteriaVO limitCriteriaVO) {

        Session session = null;
        List<?> assets = null;
        try {
            session = sessionFactory.openSession();
            String sql = CustomSQLUtil.get(FIND_BASE);
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
            sb.append(CustomSQLUtil.get(SQLConstants.LIMIT));
            if (StringUtil.isNotEmpty(limitCriteriaVO.getOrderBy())) {
                sb.append(CustomSQLUtil.get(SQLConstants.ORDER));
            } else {
                sb.append(CustomSQLUtil.getDefaultOrder());
            }
            sql = sb.toString();
            SQLQuery query = session.createSQLQuery(sql);
            if (area != null) {
                query.setParameter(0, area.getName());
            }
            if (tag != null) {
                query.setParameter(1, tag.getName());
            }
            if (category != null) {
                query.setParameter(2, category.getName());
            }
            query.setParameter(3, limitCriteriaVO.getIndex());
            query.setParameter(4, limitCriteriaVO.getPerPageItems());
            if (StringUtil.isNotEmpty(limitCriteriaVO.getOrderBy())) {
                query.setParameter(5, limitCriteriaVO.getOrderBy());
                query.setParameter(6, limitCriteriaVO.isDESC());
            }
            query.addEntity(VideoAsset.class);
            assets = query.list();
        } catch (Exception e) {
            log.error(e);
        } finally {
            close(session);
        }
        return assets;
    }

    @Override
    public List<?> find(Area area) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> find(Tag tag) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> find(String keywords) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> find(Category category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int count(Area area, Tag tag, Category category, String keywords) {

        Session session = null;
        try {
            session = sessionFactory.openSession();
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
            if (area != null) {
                query.setParameter(0, area.getName());
            }
            if (tag != null) {
                query.setParameter(1, tag.getName());
            }
            if (category != null) {
                query.setParameter(2, category.getName());
            }
            return (int)(long)query.uniqueResult();
        } catch(Exception e) {
            log.error(e);
        } finally {
            close(session);
        }
        return 0;
    }

    @Override
    public Video getVideo(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Video video) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void save(List<Video> videos) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Video video) {
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
    
    private String initSQLForAsset(String sql) {
        sql = sql.replace("[$ADD_RESAULT_CATEGORY$]", CustomSQLUtil.get("ADD_RESAULT_CATEGORY"));
        sql = sql.replace("[$ADD_RESAULT_AREA$]", CustomSQLUtil.get("ADD_RESAULT_AREA"));
        sql = sql.replace("[$ADD_RESAULT_TAG$]", CustomSQLUtil.get("ADD_RESAULT_TAG"));
        sql = sql.replace("[$INNER_TABLE_CATEGORY$]", CustomSQLUtil.get("INNER_TABLE_CATEGORY"));
        sql = sql.replace("[$INNER_TABLE_AREA$]", CustomSQLUtil.get("INNER_TABLE_AREA"));
        sql = sql.replace("[$INNER_TABLE_TAG$]", CustomSQLUtil.get("INNER_TABLE_TAG"));
        return sql;
    }
    
    private static final Log log = LogFactoryUtil.getLog(VideoDao.class);

}
