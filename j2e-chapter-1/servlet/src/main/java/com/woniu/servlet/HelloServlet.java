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
		
//		//配置UTF-8字符集以支持中文
//        response.setContentType("text/html;charst=utf-8");
//        response.setCharacterEncoding("UTF-8");
//        //获取输出流以输出数据到浏览器中
//        PrintWriter pw =  response.getWriter();
//        pw.write("我是Servlet服务端发送给浏览器的数据:Hello Servlet！");
//        pw.close();
		response.setContentType("text/html;charst=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "张三";
		int age = 16;
		PrintWriter pw =  response.getWriter();
		pw.write("<p style='color:red'>你好，我叫"+name+",今年"+age+"岁!<p>");
		pw.close();
	}
}
