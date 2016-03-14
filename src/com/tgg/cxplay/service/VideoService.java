package com.tgg.cxplay.service;

import java.util.List;

import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.model.Area;
import com.tgg.cxplay.model.Category;
import com.tgg.cxplay.model.Tag;
import com.tgg.cxplay.model.Video;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;

public interface VideoService {

    public List<Video> find();
    public List<Video> find(Tag tag, LimitCriteriaVO limitCriteriaVO) throws ParamException;
    public List<Video> find(Area area, LimitCriteriaVO limitCriteriaVO) throws ParamException;
    public List<Video> find(Category category, LimitCriteriaVO limitCriteriaVO) throws ParamException;
    public Video getVideo(int id) throws ParamException;
    public List<Video> find(int[] ids) throws ParamException;
    public int save(Video video) throws ParamException;
    public void save(List<Video> videos) throws ParamException;
    public boolean update(Video video);
    public boolean delete(int id);
    public boolean delete(int[] ids);
}
