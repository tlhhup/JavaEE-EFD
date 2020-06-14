package com.woniu.controller;


import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class TestController {
	
	/**
	 * 到登錄页面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login.jsp";
	}
	/**
	 * 登录请求
	 * @2return
	 */
	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		//错误信息
		String error = null;
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			error = "用户名/密码错误";
		} catch (IncorrectCredentialsException e) {
			error = "用户名/密码错误";
		} catch (Exception e) {
			error = "小店刚刚在登录时发生了一丢丢未知错误，请稍后重试";
		}
		System.out.println(subject.getPrincipal());
		if(error != null) {
			session.setAttribute("msg", error);
			return "/login.jsp";
		}
		return "redirect:/jsp/index.jsp";
	}
	@RequestMapping("/index")
	public String index() {
		
		return "index.jsp";
	}
	
	@RequestMapping("/list")
	public String list() {
		
		return "index.jsp";
	}
	@RequestMapping("/roles")
	public String roles() {
		
		return "index.jsp";
	}
	
}
