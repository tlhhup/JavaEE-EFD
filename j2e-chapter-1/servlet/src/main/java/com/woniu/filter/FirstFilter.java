package com.woniu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter{
	//�˷���Ϊ��ʼ������
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	//FilterChain��������������һ��������һ����������������������web.xml���õ�˳�򣬽���������װΪ��������
			//ִ��doFilter����������request��response������ô��ǰ������ִ����ɣ�������һ�����������ϵ���������������
			//�������󲻻�����ִ��
	//��дdoFilter�������˷���Ϊ���ط���
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("First��������ǰ�ò���");
		chain.doFilter(request, response);
		//��dofilter����֮�����ǿ����ٴζ�request��response������д�����ʱ�����Ѿ�
		//������Servlet�Ĵ�������ȡ����JstlServlet���а󶨵�name����
		System.out.println(request.getAttribute("name"));;
		System.out.println("First����������ò���");
	}
	//���ٷ���
	public void destroy() {
	}
}
