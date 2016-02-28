package com.tgg.cxplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/video")
public class VideoController {

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public void test() {
        System.out.println("test");
    }

}
