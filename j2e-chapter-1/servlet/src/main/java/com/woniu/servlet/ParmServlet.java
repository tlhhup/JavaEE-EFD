package com.woniu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParmServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����ݵ�reqeust����
		req.setAttribute("msg", "��ã����ǰ���Reuqest�����ϵĶ���");
		//ת����el.jsp
		req.getRequestDispatcher("el.jsp").forward(req, resp);
	}
}
