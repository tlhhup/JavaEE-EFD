package com.woniu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JstlServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//绑定数据到request对象
		req.setAttribute("name", "李四");
		req.setAttribute("age", 25);
		//获取转发器并转发到jstl.jsp
		System.out.println("JstlServlet service方法运行");
		req.getRequestDispatcher("jstl.jsp").forward(req, resp);
	}
}
