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
	 * ��дservice����
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		//����UTF-8�ַ�����֧������
//        response.setContentType("text/html;charst=utf-8");
//        response.setCharacterEncoding("UTF-8");
//        //��ȡ�������������ݵ��������
//        PrintWriter pw =  response.getWriter();
//        pw.write("����Servlet����˷��͸������������:Hello Servlet��");
//        pw.close();
		response.setContentType("text/html;charst=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "����";
		int age = 16;
		PrintWriter pw =  response.getWriter();
		pw.write("<p style='color:red'>��ã��ҽ�"+name+",����"+age+"��!<p>");
		pw.close();
	}
}
