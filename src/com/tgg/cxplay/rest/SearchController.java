package com.tgg.cxplay.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.model.Area;
import com.tgg.cxplay.model.Category;
import com.tgg.cxplay.model.Tag;
import com.tgg.cxplay.model.Video;
import com.tgg.cxplay.model.vo.LimitCriteriaVO;
import com.tgg.cxplay.model.vo.PagerVO;
import com.tgg.cxplay.service.VideoService;

@Controller
@RequestMapping("/rest")
public class SearchController {

    @Autowired
    private VideoService videoService;

    @ResponseBody
    @RequestMapping(value="/medias", produces="application/json;charset=utf-8")
    public String find() {
        List<Video> videos = null;
        videos = videoService.find();
        if (videos != null && videos.size() > 0) {
        	Gson gson = new Gson();
            return gson.toJson(videos);
        }
        return null;
    }
    
    @ResponseBody
    @RequestMapping(value="/medias/tag/{tag}", produces="application/json;charset=utf-8")
    public String findByTag(@PathVariable String tag) {
    	PagerVO pager = new PagerVO();
    	Tag t = new Tag();
    	t.setName(tag);
    	pager.setIndex(0);
    	pager.setPerPageItems(100);
    	pager.setCurrentPage(1);
    	
    	LimitCriteriaVO limitCriteriaVO = new LimitCriteriaVO();
    	limitCriteriaVO.setCurrentPage(pager.getCurrentPage());
    	limitCriteriaVO.setDESC(true);
    	limitCriteriaVO.setPerPageItems(pager.getPerPageItems());
    	
    	try {
			pager.setVideoList(videoService.find(t, limitCriteriaVO));
		} catch (ParamException e) {
			return e.toString();
		}
    	
    	pager.setTotalItems(limitCriteriaVO.getTotalItems());
    	pager.setIndex(limitCriteriaVO.getIndex());
    	pager.setCurrentPage(limitCriteriaVO.getCurrentPage());
    	
        if (pager.getVideoList() != null) {
            Gson gson = new Gson();
            return gson.toJson(pager);
        }
        return null;
    }
    
    @ResponseBody
    @RequestMapping(value="/medias/area/{area}", produces="application/json;charset=utf-8")
    public String findByArea(@PathVariable String area) {
    	PagerVO pager = new PagerVO();
    	Area a = new Area();
    	a.setName(area);
    	pager.setIndex(0);
    	pager.setPerPageItems(100);
    	pager.setCurrentPage(1);
    	
    	LimitCriteriaVO limitCriteriaVO = new LimitCriteriaVO();
    	limitCriteriaVO.setCurrentPage(pager.getCurrentPage());
    	limitCriteriaVO.setDESC(true);
    	limitCriteriaVO.setPerPageItems(pager.getPerPageItems());
    	
    	try {
			pager.setVideoList(videoService.find(a, limitCriteriaVO));
		} catch (ParamException e) {
			return e.toString();
		}
    	
    	pager.setTotalItems(limitCriteriaVO.getTotalItems());
    	pager.setIndex(limitCriteriaVO.getIndex());
    	pager.setCurrentPage(limitCriteriaVO.getCurrentPage());
    	
        if (pager.getVideoList() != null) {
            Gson gson = new Gson();
            return gson.toJson(pager);
        }
        return null;
    }
    
    @ResponseBody
    @RequestMapping(value="/medias/category/{category}", produces="application/json;charset=utf-8")
    public String findByCategory(@PathVariable String category) {
    	PagerVO pager = new PagerVO();
    	Category c = new Category();
    	c.setName(category);
    	pager.setIndex(0);
    	pager.setPerPageItems(100);
    	pager.setCurrentPage(1);
    	
    	LimitCriteriaVO limitCriteriaVO = new LimitCriteriaVO();
    	limitCriteriaVO.setCurrentPage(pager.getCurrentPage());
    	limitCriteriaVO.setDESC(true);
    	limitCriteriaVO.setPerPageItems(pager.getPerPageItems());
    	
    	try {
			pager.setVideoList(videoService.find(c, limitCriteriaVO));
		} catch (ParamException e) {
			return e.toString();
		}
    	
    	pager.setTotalItems(limitCriteriaVO.getTotalItems());
    	pager.setIndex(limitCriteriaVO.getIndex());
    	pager.setCurrentPage(limitCriteriaVO.getCurrentPage());
    	
        if (pager.getVideoList() != null) {
            Gson gson = new Gson();
            return gson.toJson(pager);
        }
        return null;
    }
    
    @ResponseBody
    @RequestMapping(value="/media/{id}", produces="application/json;charset=utf-8")
    public String get(@PathVariable int id) {
        try {
        	Video video = videoService.getVideo(id);
			if (video != null) {
				Gson gson = new Gson();
				return gson.toJson(video);
			}
		} catch (ParamException e) {
			return e.toString();
		}
        return null;
    }

}
