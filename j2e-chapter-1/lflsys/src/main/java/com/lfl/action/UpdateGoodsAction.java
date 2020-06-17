package com.lfl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateGoodsAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(req.getParameter("id"));
			Integer brandID = Integer.parseInt(req.getParameter("brandID"));
			System.out.println("id: " + id);
			System.out.println("brandID: " + brandID);
			
			//将update xxxx set xxx =  brandID  where id=id ........
			//返回主页
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
