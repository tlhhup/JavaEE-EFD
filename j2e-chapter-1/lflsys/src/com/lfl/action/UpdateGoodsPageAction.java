package com.lfl.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lfl.dao.BrandDao;
import com.lfl.dao.GoodsDao;
import com.lfl.dao.impl.BrandDaoImpl;
import com.lfl.dao.impl.GoodsDaoImpl;
import com.lfl.model.Brand;
import com.lfl.model.Goods;

public class UpdateGoodsPageAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(req.getParameter("id"));
			
			
			GoodsDao gd = new GoodsDaoImpl();
			BrandDao bd = new BrandDaoImpl();
			
			
			Goods goods = gd.findById(id);
			//一二级分类不写了，参考名称。。。。
			List<Brand> brandList = bd.queryAll();
			
			req.setAttribute("goods", goods);
			req.setAttribute("brandList", brandList);
			req.getRequestDispatcher("WEB-INF/page/updateGoods.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
