package com.woniu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woniu.entity.User;

public class BeanServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//tomcat8  自动处理
		//
		String uname = req.getParameter("uname");
		
		byte[] bytes = uname.getBytes("ISO8859-1");
		uname = new String(bytes,"utf-8");
		
		HttpSession session = req.getSession();
		User user = new User();
		user.setName("张三");
		user.setAge(20);
		session.setAttribute("user", user);
		//创建Map对象，存入name和age属性
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name","张三");
		map.put("age", 25);
		session.setAttribute("map", map);
		//创建list对象，存入数据
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("xyz");
		session.setAttribute("list", list);
		//转发到el.jsp
		req.getRequestDispatcher("el.jsp").forward(req, resp);
	}
}
