package com.woniu.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class LoginController {
	@RequestMapping("toLogin")
	public String login() {
		return "login.jsp";
	}
	@RequestMapping("login")
	public String doLogin(String username , String password , HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		String error = null;
		try {
//			Md5Hash
			subject.login(token);
		} catch (UnknownAccountException e) {  
	        error = "用户名/密码错误";  
	    } catch (IncorrectCredentialsException e) {  
	        error = "用户名/密码错误";  
	    } catch (AuthenticationException e) {  
	        error = "其他错误：" + e.getMessage();  
	    }
		//登录没有成功,跳转到登录页面，并绑定错误信息
		if(error!=null) {
			session.setAttribute("error", error);
			return "login.jsp";
		}
		return "redirect:index";
	}
	//退出登录
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login.jsp";
	}
	//需要身份验证才能进行访问
	@RequestMapping("index")
	public String index() {
		return "index.jsp";
	}
	//需要user:view权限
	@RequestMapping("list")
	public String list() {
		return "index.jsp";
	}
	//需要system角色才能访问
	@RequestMapping("roles")
	public String roles() {
		return "index.jsp";
	}
}
