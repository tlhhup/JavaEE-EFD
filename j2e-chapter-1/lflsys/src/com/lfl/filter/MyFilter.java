package com.lfl.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lfl.model.Func;
import com.lfl.model.Model;

public class MyFilter implements Filter{
	//不需要登录验证的请求
	private List<String> actionName;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//通过拦截器设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		
		//获取当前进入拦截器的请求，与集合中的元素对比,如果当前请求存在集合中，则直接放过
//		String url = req.getRequestURL().toString();
		String uri = req.getRequestURI();
		
		
		String nowAction = uri.substring( uri.lastIndexOf("/")+1 );
		for (String actionStr : actionName) {
			if( nowAction.equals(actionStr) ){
				chain.doFilter(req, resp);
				return;
			}
		}
		
		
		
		//获取session中的登录用户,判断该用户是否经过登录的流程
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("loginManager");
		if( obj == null ){//没经过登录流程
			System.out.println("该用户没有登录！");
			req.getRequestDispatcher("WEB-INF/page/login.jsp").forward(req, resp);
			return;
		}
		
		//心跳请求不需要权限验证
		if( uri.contains("heart.action") ){
			//放过请求
			chain.doFilter(req, resp);
			return;
		}
		
		
		
		//权限验证
		uri = uri.replaceAll(req.getServletContext().getContextPath(), "");
		boolean isURLFunc = false;
		Map<String, Map<String, String>> qxMap = (Map<String, Map<String, String>>)session.getAttribute("modelMap");
		Collection<Map<String, String>> coll = qxMap.values();
		Iterator<Map<String, String>> it = coll.iterator();
		while( it.hasNext() ){
			Map<String, String> funcURLMap = it.next();
			if( funcURLMap.get(uri) != null ){
				isURLFunc = true;
				break;
			}else{
				isURLFunc = false;
			}
		}
		if( !isURLFunc ){//没有权限
			req.getRequestDispatcher("WEB-INF/page/error.jsp").forward(req, resp);
			return;
		}
		
		
		
		

		
		
		//放过请求
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//初始化不需要登录验证的请求
		actionName = new ArrayList<String>();
		actionName.add("loginPage.action");
		actionName.add("login.action");
		actionName.add("logout.action");
		//心跳请求
//		actionName.add("heart.action");
	}
	
}
