package com.lfl.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lfl.dao.GoodsDao;
import com.lfl.dao.impl.GoodsDaoImpl;
import com.lfl.model.Goods;
public class IndexPageAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			//获取session中的登录用户,判断该用户是否经过登录的流程
//			HttpSession session = req.getSession();
//			Object obj = session.getAttribute("loginManager");
//			if( obj == null ){//没经过登录流程
//				resp.sendRedirect("loginPage.action");
//				return;
//			}
			
			//查询所有库存产品
			GoodsDao gd = new GoodsDaoImpl();
			List<Goods> list = gd.queryAll();
			
			
			//转发到主页
			req.setAttribute("goodsList", list);
			req.getRequestDispatcher("WEB-INF/page/index.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
