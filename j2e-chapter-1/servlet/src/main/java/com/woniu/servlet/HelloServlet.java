package com.woniu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	@Override
	/**
	 * 重写service方法
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charst=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "张三";
		int age = 16;
		PrintWriter pw =  response.getWriter();
		pw.write("<p style='color:red'>你好，我叫"+name+",今年"+age+"岁!<p>");
		pw.close();
	}
}
