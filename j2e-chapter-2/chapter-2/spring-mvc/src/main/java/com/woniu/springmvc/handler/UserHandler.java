package com.woniu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
@Controller // 标识该类为Spring MVC中的handler
@RequestMapping("/UserHandler")
public class UserHandler {

    @RequestMapping("/login") // 标识url地址的
    public String doLogin(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if ("admin".equals(password) && "admin".equals(userName)) {
            return "success";
        } else {
            return "fail";// 逻辑视图名
        }
    }
}
