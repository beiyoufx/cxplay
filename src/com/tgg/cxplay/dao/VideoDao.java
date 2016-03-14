package com.tgg.cxplay.dao;

import java.util.List;

import com.tgg.cxplay.model.Area;
import com.tgg.cxplay.model.Category;
import com.tgg.cxplay.model.Tag;
import com.tgg.cxplay.model.Video;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;
import com.tgg.cxplay.model.vo.VideoVO;

/** 
 * @ClassName VideoDao
 * @Description Definition methods for video CRUD.
 * @author Jerry Teng
 * @date 2015/7/7 22:15:15
 */
public interface VideoDao {
    public List<Video> find();
    public List<Video> find(Area area, Tag tag, Category category, String keywords, LimitCriteriaVO limitCriteriaVO);
    public List<Video> find(Area area, LimitCriteriaVO limitCriteriaVO);
    public List<Video> find(Tag tag, LimitCriteriaVO limitCriteriaVO);
    public List<Video> find(String keywords, LimitCriteriaVO limitCriteriaVO);
    public List<Video> find(Category category, LimitCriteriaVO limitCriteriaVO);
    public int count(Area area, Tag tag, Category category, String keywords);
    public Video getVideo(int id);
    public int save(VideoVO videoVO);
    public int update(VideoVO videoVO);
    public int delete(int id);
    public void update_V_A(int videoId, int areaId);
    public void update_V_T(int videoId, int TagId);
    public void update_V_C(int videoId, int CategoryId);
}
