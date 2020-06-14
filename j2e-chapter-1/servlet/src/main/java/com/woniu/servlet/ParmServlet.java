package com.woniu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParmServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//绑定数据到reqeust对象
		req.setAttribute("msg", "你好，我是绑定在Reuqest对象上的对象");
		//转发到el.jsp
		req.getRequestDispatcher("el.jsp").forward(req, resp);
	}
}
