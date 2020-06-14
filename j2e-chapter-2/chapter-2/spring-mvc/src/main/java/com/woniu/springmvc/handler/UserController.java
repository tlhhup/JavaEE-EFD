package com.woniu.springmvc.handler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public class UserController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView=new ModelAndView();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if("admin".equals(password)&&"admin".equals(userName)){
            modelAndView.setViewName("success");
        }else{
            modelAndView.setViewName("fail");
        }
        return modelAndView;
    }

}
