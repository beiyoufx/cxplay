package com.tgg.cxplay.dao;

import java.util.List;

import com.tgg.cxplay.model.Area;
import com.tgg.cxplay.model.Category;
import com.tgg.cxplay.model.Tag;
import com.tgg.cxplay.model.Video;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;

/** 
 * @ClassName VideoDao
 * @Description Definition methods for video CRUD.
 * @author Jerry Teng
 * @date 2015/7/7 22:15:15
 */
public interface VideoDao {
    public List<?> find();
    public List<?> find(int[] ids);
    public List<?> find(Area area, Tag tag, Category category, String keywords, LimitCriteriaVO limitCriteriaVO);
    public List<?> find(Area area);
    public List<?> find(Tag tag);
    public List<?> find(String keywords);
    public List<?> find(Category category);
    public int count(Area area, Tag tag, Category category, String keywords);
    public Video getVideo(int id);
    public void save(Video video);
    public void save(List<Video> videos);
    public void update(Video video);
    public void delete(int id);
    public void delete(int[] ids);
}
