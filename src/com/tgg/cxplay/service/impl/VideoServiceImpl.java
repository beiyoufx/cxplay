package com.tgg.cxplay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tgg.cxplay.dao.VideoDao;
import com.tgg.cxplay.exception.EparamError;
import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.log.Log;
import com.tgg.cxplay.log.LogFactoryUtil;
import com.tgg.cxplay.model.Area;
import com.tgg.cxplay.model.Category;
import com.tgg.cxplay.model.Tag;
import com.tgg.cxplay.model.Video;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;
import com.tgg.cxplay.service.VideoService;
import com.tgg.cxplay.service.util.ServiceUtil;
import com.tgg.cxplay.util.StringUtil;

@Service
public class VideoServiceImpl implements VideoService {
	
    private VideoDao videoDao;
    public void setVideoDao(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

	@Override
	public List<Video> find() {
		return videoDao.find();
	}

	@Override
	public List<Video> find(Tag tag, LimitCriteriaVO limitCriteriaVO) throws ParamException {
		
		ParamException pe = null;
		if (tag == null) {
			pe = new ParamException(EparamError.TAG_NULL, "Tag is required");
			throw pe;
		}
		tag = ServiceUtil.getTagService().get(tag);
		if (tag == null) {
			pe = new ParamException(EparamError.TAG_NOT_EXIST, "Tag not exist");
			throw pe;
		}
		return videoDao.find(tag, limitCriteriaVO);
	}

	@Override
	public List<Video> find(Area area, LimitCriteriaVO limitCriteriaVO) throws ParamException {
		
		ParamException pe = null;
		if (area == null) {
			pe = new ParamException(EparamError.AREA_NULL, "Area is required");
			throw pe;
		}
		area = ServiceUtil.getAreaService().get(area);
		if (area == null) {
			pe = new ParamException(EparamError.AREA_NOT_EXIST, "Area not exist");
			throw pe;
		}
		return videoDao.find(area, limitCriteriaVO);
	}

	@Override
	public List<Video> find(Category category,
			LimitCriteriaVO limitCriteriaVO) throws ParamException {
		
		ParamException pe = null;
		if (category == null) {
			pe = new ParamException(EparamError.CATEGORY_NULL, "Category is required");
			throw pe;
		}
		category = ServiceUtil.getCategoryService().get(category);
		if (category == null) {
			pe = new ParamException(EparamError.CATEGORY_NOT_EXIST, "Category not exist");
			throw pe;
		}
		return videoDao.find(category, limitCriteriaVO);
	}

	@Override
	public Video getVideo(int id) throws ParamException {
		
		ParamException pe = null;
		if (id == 0) {
			pe = new ParamException(EparamError.VIDEO_ID_NULL, "Video ID is required");
			throw pe;
		}
		return videoDao.getVideo(id);
	}

	@Override
	public List<Video> find(int[] ids) throws ParamException {
		
		List<Video> videos = new ArrayList<Video>();
    	for (int id : ids) {
    		Video tempAsset = getVideo(id);
    		if (tempAsset != null) {
    			videos.add(tempAsset);
    		}
    	}
		return videos;
	}
	
	@Override
	public int save(Video video) throws ParamException {
		
		ParamException pe = null;
		if (video == null) {
			pe = new ParamException(EparamError.VIDEO_NULL, "Video is required");
			throw pe;
		}
		if (StringUtil.isEmpty(video.getName())) {
			pe = new ParamException(EparamError.VIDEO_NAME_NULL, "Video Name is required");
			throw pe;
		}
		if (StringUtil.isEmpty(video.getUrl())) {
			pe = new ParamException(EparamError.VIDEO_URL_NULL, "Video Url is required");
			throw pe;
		}
		if (StringUtil.isEmpty(video.getPic())) {
			pe = new ParamException(EparamError.VIDEO_PIC_NULL, "Video Sumbnail is required");
			throw pe;
		}
		if (video.getEpisode() == 0) {
			video.setEpisode(1);
		}
		int id = videoDao.save(video.getVideoVO());
		
		if (id == 0) {
			log.error("Save Video Error: Cannot save the video, [id:" + id + "]");
			return 0;
		}
		
		if (StringUtil.isNotEmpty(video.getArea())) {
			Area area = ServiceUtil.getAreaService().get(video.getArea());
			if (area != null) {
				videoDao.update_V_A(id, area.getId());
			}
		}
		if (StringUtil.isNotEmpty(video.getCategory())) {
			Category category = ServiceUtil.getCategoryService().get(video.getCategory());
			if (category != null) {
				videoDao.update_V_C(id, category.getId());
			}
		}
		if (StringUtil.isNotEmpty(video.getTag())) {
			Tag tag = ServiceUtil.getTagService().get(video.getTag());
			if (tag != null) {
				videoDao.update_V_T(id, tag.getId());
			}
		}
		return id;
	}
	
	@Override
	public void save(List<Video> videos) throws ParamException {

		for (Video videoAsset : videos) {
			save(videoAsset);
		}
	}
	
	@Override
	public boolean delete(int id) {
		
		int status = videoDao.delete(id);
		if (status == 0) {
			log.error("Delete Video Error: Cannot delete the video, [id:" + id + "]");
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

	@Override
	public boolean update(Video video) {
		
		int status = videoDao.update(video.getVideoVO());
		if (status == 0) {
			log.error("Update Video Error: Cannot update the video, [id:" + video.getId() + "]");
			return false;
		}
		return true;
	}
	
	private static final Log log = LogFactoryUtil.getLog(VideoService.class);
}
