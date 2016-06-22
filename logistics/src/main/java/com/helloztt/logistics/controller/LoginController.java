package com.helloztt.logistics.controller;

import com.helloztt.logistics.entity.author.User;
import com.helloztt.logistics.service.user.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by helloztt on 2016/6/20.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"","/","/login"})
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/loginFailed")
    public String loginFailed(HttpServletRequest request, RedirectAttributes attributes){
        return "redirect:login";
    }

    @RequestMapping(value = "/index")
    public String index(@AuthenticationPrincipal User user){
        return "home";
    }

}
