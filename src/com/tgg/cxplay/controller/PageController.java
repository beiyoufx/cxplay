package com.tgg.cxplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login() {
        return "login";
    }
}
