package com.tgg.cxplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.model.Video;
import com.tgg.cxplay.service.VideoService;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;
    
    @RequestMapping(value="/test", produces="application/json;charset=utf-8")
    @ResponseBody
    public String test() {
        Video videoAsset = new Video();
        videoAsset.setActors("test");
        videoAsset.setClarity("540P");
        videoAsset.setDirectors("test");
        videoAsset.setEnName("enTest");
        videoAsset.setEpisode(1);
        videoAsset.setName("test");
        videoAsset.setPic("default.jpg");
        videoAsset.setSynopsis("testtest");
        videoAsset.setUrl("utllllllll");
        videoAsset.setTag("swordsmen");
        videoAsset.setCategory("film");
        videoAsset.setArea("cn");
        try {
            int id = videoService.save(videoAsset);
            Video newVideo = videoService.getVideo(id);
            if (newVideo != null) {
                Gson gson = new Gson();
                return gson.toJson(newVideo);
            }
        } catch (ParamException e) {
            return e.toString();
        }
        return null;
    }

}
