package com.woniu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String uname = req.getParameter("uname");
		// String password = req.getParameter("password");
		// //ͨ��request��ȡ��session����
		// HttpSession session = req.getSession();
		// if("zhangsan".equals(uname)) {
		// if("123456".equals(password)) {
		// //��¼�ɹ������û����ݴ洢��session������
		// session.setAttribute("uname", uname);
		// RequestDispatcher dispatcher =
		// req.getRequestDispatcher("index.jsp");
		// dispatcher.forward(req, resp);
		// return;
		// }
		// }
		// //�����û���ʾ�����ǲ�����ʾ����������������û�������
		// session.setAttribute("msg", "�û������������");
		// RequestDispatcher dispatcher =
		// req.getRequestDispatcher("index.jsp");
		// dispatcher.forward(req, resp);
		// return;
		String uname = req.getParameter("uname");
		String password = req.getParameter("password");
		// ͨ��request��ȡsession����
		HttpSession session = req.getSession();
		if ("zhangsan".equals(uname)) {
			if ("123456".equals(password)) {
				// ��¼�ɹ������û����ݴ洢��session������
				session.setAttribute("uname", uname);
				// �ض���index.jsp
				resp.sendRedirect("index.jsp");
				return;
			}
		}
		// �����û���ʾ�����ǲ�����ʾ������������û�������
		session.setAttribute("msg", "�û������������");
		resp.sendRedirect("login.jsp");
	}
}
