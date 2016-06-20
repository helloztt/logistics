package com.helloztt.logistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by helloztt on 2016/6/20.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"","/","/login","/index"})
    public String login(){
        return "login";
    }
}
