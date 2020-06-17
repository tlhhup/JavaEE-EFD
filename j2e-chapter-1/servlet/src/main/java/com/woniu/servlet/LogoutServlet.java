package com.woniu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//退出登录功能
		//需要将session的用户信息清除、同时重定向到登录页面
		HttpSession session = req.getSession();
		//使session失效
		session.invalidate();
		//重定向到登录页面
		resp.sendRedirect("login.jsp");
	}
}
