package com.tgg.cxplay.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tgg.cxplay.dao.VideoDao;
import com.tgg.cxplay.model.VideoAsset;
import com.tgg.cxplay.service.SearchService;

/** 
 * @ClassName SearchServiceImpl
 * @Description provide some public service for video search.
 * @author Jerry Teng
 * @date Jul 11, 2015 9:47:17 PM
 */
@Service
public class SearchServiceImpl implements SearchService{
    
    private VideoDao videoDao;

    public void setVideoDao(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VideoAsset> find() {
        List<?> assets = videoDao.find();
        return (List<VideoAsset>) assets;
    }
    
    //private static final Log log = LogFactoryUtil.getLog(SearchService.class);

}
