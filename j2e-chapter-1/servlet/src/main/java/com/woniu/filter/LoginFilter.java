package com.woniu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//��ServletRequestת��ΪHttpServletRequest
		HttpServletRequest req = (HttpServletRequest)request;
		//��ServletResponseת��ΪHttpServletResponse
		HttpServletResponse resp = (HttpServletResponse)response;
		//��ȡ�������ַURI
		String uri = req.getRequestURI();
		//����һ�� '/'��ȡ��
		uri = uri.substring(1);
		//ȥ��·������Ŀ����
		uri = uri.substring(uri.indexOf('/')+1);
		//�������Ϊlogin������login.jsp��ִ�в�����
		if("login".equals(uri) || "login.jsp".equals(uri)) {
			chain.doFilter(req, resp);
			return;
		}
		//��ȡ��session����
		HttpSession session = req.getSession();
		//��ȡ������session�����ϵ�uname����(����������LoginServlet�û���¼�ɹ�֮��洢��Session�����е�����)
		String uname = (String)session.getAttribute("uname");
		//uname��Ϊ�ջ��߿��ַ��������ʾ�û��Ѿ���¼
		if(uname!=null && !"".equals(uname)) {
			chain.doFilter(req, resp);
			return;
		}
		//����û�û�е�¼��������·������login����login.jsp�����ض���login.jspҳ��
		resp.sendRedirect("login.jsp");
	}
	public void destroy() {
	}
}
