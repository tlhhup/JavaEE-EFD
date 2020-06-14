package com.lfl.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lfl.dao.ManagerDao;
import com.lfl.dao.impl.ManagerDaoImpl;
import com.lfl.model.Manager;

public class LogoutAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			HttpSession session = req.getSession();
//			Manager manager = (Manager)session.getAttribute("loginManager");
//			ManagerDao md = new ManagerDaoImpl();
//			md.setIsLogin(0, manager.getId());
			
			//session处理
			//将loginManager绑定对象从该会话的session中删除
//			session.removeAttribute("loginManager");
			
			
			//从会话中销毁session
			req.getSession().invalidate();
			resp.sendRedirect("loginPage.action");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
