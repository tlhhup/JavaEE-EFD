package com.lfl.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lfl.dao.EmplyeeDao;
import com.lfl.dao.impl.EmplyeeDaoImpl;
import com.lfl.model.Emplyee;

import net.sf.json.JSONObject;

public class CheckEmpAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("application/json;charset=utf-8");
		try {
			String name = req.getParameter("name");
			EmplyeeDao ed = new EmplyeeDaoImpl();
			Emplyee emp = ed.queryByName(name);
			
			PrintWriter out = resp.getWriter();
			JSONObject json = new JSONObject();
			
			if( emp == null ){
//				out.print("OK");
				json.put("msg", "OK");
			}else{
//				out.print("Error");
				json.put("msg", "Error");
			}
			System.out.println(json);
			
			out.println(json.toString());
			
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
}
