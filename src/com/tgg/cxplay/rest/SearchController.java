package com.tgg.cxplay.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tgg.cxplay.model.VideoAsset;
import com.tgg.cxplay.service.SearchService;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ResponseBody
    @RequestMapping("/media")
    public String find() {
        List<VideoAsset> videoAssets = null;
        videoAssets = searchService.find();
        if (videoAssets != null) {
            Gson gson = new Gson();
            if (videoAssets.size() > 0) {
                return gson.toJson(videoAssets);
            }
        }
        return null;
    }

}
