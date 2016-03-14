package com.tgg.cxplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tgg.cxplay.exception.ParamException;
import com.tgg.cxplay.model.User;
import com.tgg.cxplay.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        
        try {
            user = userService.getUser(username, password);
        } catch (ParamException e) {
            System.out.println(e);
            return "/login";
        }
        System.out.println(user);
        return "rest/medias";
    }
    @RequestMapping(value = "/find", produces="application/json;charset=utf-8")
    @ResponseBody
    public String find() {
        
        List<User> users = userService.find();
        if (users != null && users.size() > 0) {
            Gson gson = new Gson();
            return gson.toJson(users);
        }
        return null;
    }
}
