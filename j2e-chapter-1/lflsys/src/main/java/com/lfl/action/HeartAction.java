package com.lfl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lfl.cache.SessionCache;

public class HeartAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//更新当前用户session中的时间戳
//		HttpSession session = req.getSession();
//		session.setAttribute("heartTime", System.currentTimeMillis());
		
	}
}
