package com.woniuxy.ssm.controller;

import com.woniuxy.ssm.entity.User;
import com.woniuxy.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User userInfo = this.userService.validateUserInfo(user);
        if(userInfo!=null){
            session.setAttribute("user", userInfo);
            return "success";
        }else{
            return "login";
        }
    }

}