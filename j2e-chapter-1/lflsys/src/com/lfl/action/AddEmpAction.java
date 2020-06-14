package com.lfl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lfl.dao.EmplyeeDao;
import com.lfl.dao.impl.EmplyeeDaoImpl;

public class AddEmpAction extends HttpServlet{
	/**
	 * xxxxx
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			synchronized(this){
				String name = req.getParameter("name");
				EmplyeeDao ed = new EmplyeeDaoImpl();
				ed.add(name);
				resp.sendRedirect("indexPage.action");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
