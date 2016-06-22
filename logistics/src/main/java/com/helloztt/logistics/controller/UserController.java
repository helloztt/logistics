package com.helloztt.logistics.controller;

import com.helloztt.logistics.entity.author.User;
import com.helloztt.logistics.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by helloztt on 2016/6/22.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public String addUser(){
        User user = new User();
        user.setUsername("1");
        user.setPassword("1");
        user.setDeleted(false);
        user.setDisabled(false);
        userService.addUser(user);
        return "success";
    }
}
