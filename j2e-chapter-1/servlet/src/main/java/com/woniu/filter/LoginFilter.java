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
		//将ServletRequest转换为HttpServletRequest
		HttpServletRequest req = (HttpServletRequest)request;
		//将ServletResponse转换为HttpServletResponse
		HttpServletResponse resp = (HttpServletResponse)response;
		//获取到请求地址URI
		String uri = req.getRequestURI();
		//将第一个 '/'截取掉
		uri = uri.substring(1);
		//去除路径的项目名称
		uri = uri.substring(uri.indexOf('/')+1);
		//如果请求为login或者是login.jsp则执行不处理
		if("login".equals(uri) || "login.jsp".equals(uri)) {
			chain.doFilter(req, resp);
			return;
		}
		//获取到session对象
		HttpSession session = req.getSession();
		//获取到绑定在session对象上的uname属性(此数据是在LoginServlet用户登录成功之后存储在Session对象中的数据)
		String uname = (String)session.getAttribute("uname");
		//uname不为空或者空字符串，则表示用户已经登录
		if(uname!=null && !"".equals(uname)) {
			chain.doFilter(req, resp);
			return;
		}
		//如果用户没有登录并且请求路径不是login或者login.jsp，则重定向到login.jsp页面
		resp.sendRedirect("login.jsp");
	}
	public void destroy() {
	}
}
