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
		//�˳���¼����
		//��Ҫ��session���û���Ϣ�����ͬʱ�ض��򵽵�¼ҳ��
		HttpSession session = req.getSession();
		//ʹsessionʧЧ
		session.invalidate();
		//�ض��򵽵�¼ҳ��
		resp.sendRedirect("login.jsp");
	}
}
