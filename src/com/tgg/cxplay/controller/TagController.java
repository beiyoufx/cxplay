package com.tgg.cxplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tag")
public class TagController {

    @RequestMapping("")
    public String index() {
        return "index";
    }
}
