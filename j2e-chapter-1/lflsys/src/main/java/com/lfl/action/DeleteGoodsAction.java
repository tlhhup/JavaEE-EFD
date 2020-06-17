package com.lfl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lfl.dao.GoodsDao;
import com.lfl.dao.GoodsDirDao;
import com.lfl.dao.impl.GoodsDaoImpl;
import com.lfl.dao.impl.GoodsDirDaoImpl;

public class DeleteGoodsAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String idStr = req.getParameter("id");
			if( idStr == null )throw new Exception("ID是空的！");
			Integer id = Integer.parseInt(idStr);
			
			//先删除gooddir,再删除goods
			GoodsDirDao gdd = new GoodsDirDaoImpl();
			GoodsDao gd = new GoodsDaoImpl();
			
			gdd.deleteByGoodID(id);
			gd.delete(id);
			
			resp.sendRedirect("indexPage.action");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
