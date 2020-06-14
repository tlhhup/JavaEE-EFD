package com.woniu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter{
	//此方法为初始化方法
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	//FilterChain是拦截器链对象，一个请求，有一个完整的拦截器链，根据web.xml配置的顺序，将拦截器组装为拦截器链
			//执行doFilter方法，传入request、response对象，那么当前拦截器执行完成，交由下一个拦截器链上的拦截器继续拦截
			//否则请求不会向下执行
	//重写doFilter方法，此方法为拦截方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("First拦截请求前置部分");
		chain.doFilter(request, response);
		//在dofilter方法之后，我们可以再次对request和response对象进行处理，此时请求已经
		//经过了Servlet的处理，我们取出在JstlServlet类中绑定的name属性
		System.out.println(request.getAttribute("name"));;
		System.out.println("First拦截请求后置部分");
	}
	//销毁方法
	public void destroy() {
	}
}
