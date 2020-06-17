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
/*		 //���ȡsession���󴫵����ݻ���ʹ��
        //request���󴫵����ݵ�Ч������һ����,������ҪΪ������ʾʹ��session
        //�������ݵ�Ч����д��
        HttpSession session = req.getSession();
        User user = new User();
        user.setName("����");
        user.setAge(20);
        //��������user����󶨵�session����
        session.setAttribute("user", user);
        //ת����el.jsp
        req.getRequestDispatcher("el.jsp").forward(req, resp);*/

		//tomcat8  �Զ�����
		String uname = req.getParameter("uname");
		
		byte[] bytes = uname.getBytes("ISO8859-1");
		uname = new String(bytes,"utf-8");
		
		HttpSession session = req.getSession();
		User user = new User();
		user.setName("����");
		user.setAge(20);
		session.setAttribute("user", user);
		//����Map���󣬴���name��age����
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name","����");
		map.put("age", 25);
		session.setAttribute("map", map);
		//����list���󣬴�������
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("xyz");
		session.setAttribute("list", list);
		//ת����el.jsp
		req.getRequestDispatcher("el.jsp").forward(req, resp);
	}
}
