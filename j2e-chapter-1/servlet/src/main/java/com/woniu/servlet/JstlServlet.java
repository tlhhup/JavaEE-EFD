package com.woniu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JstlServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����ݵ�request����
		req.setAttribute("name", "����");
		req.setAttribute("age", 25);
		//��ȡת������ת����jstl.jsp
		System.out.println("JstlServlet service��������");
		req.getRequestDispatcher("jstl.jsp").forward(req, resp);
	}
}
