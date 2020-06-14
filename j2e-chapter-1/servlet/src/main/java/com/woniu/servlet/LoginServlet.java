package com.woniu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String password = req.getParameter("password");
		//通过request获取到session对象
		HttpSession session = req.getSession();
		if("zhangsan".equals(uname)) {
			if("123456".equals(password)) {
				//登录成功，将用户数据存储在session对象中
				session.setAttribute("uname", uname);
				//重定向到index.jsp
				resp.sendRedirect("index.jsp");
				return;
			}
		}
		//给出用户提示，但是不用提示具体是密码错误还是用户名错误
		session.setAttribute("msg", "用户名或密码错误");
		resp.sendRedirect("login.jsp");
	}
}
