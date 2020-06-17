package com.lfl.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lfl.common.Constans;
import com.lfl.dao.EmplyeeDao;
import com.lfl.dao.impl.EmplyeeDaoImpl;
import com.lfl.model.Emplyee;

public class EmpListPageAction extends HttpServlet{
	//总条数
	private Integer totalRow;
	//总页数
	private Integer pageTotal;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			Integer pageNow = (Integer)session.getAttribute("empListPageNow");
			
			//翻页方向
			String pageDir = req.getParameter("pageDir");
			//获取跳转页码
			String pagination = req.getParameter("pagination");
			
			EmplyeeDao ed = new EmplyeeDaoImpl();
			
			totalRow = ed.queryTotalRow();
			pageTotal = totalRow % Constans.PAGE.PAGEROW == 0 ? totalRow / Constans.PAGE.PAGEROW : (totalRow / Constans.PAGE.PAGEROW) + 1;
			
			if( pageDir == null ){
				pageNow = 1;
			}else if( "up".equals(pageDir) && pageNow > 1 ){
				pageNow--;
			}else if( "down".equals(pageDir) && pageNow < pageTotal ){
				pageNow++;
			}
			
			//跳转页码
			if( pagination != null )pageNow = Integer.parseInt(pagination);
			
			
			List<Emplyee> list = ed.queryEmpList(pageNow, Constans.PAGE.PAGEROW);
			
			//从新将当前页码放回session
			session.setAttribute("empListPageNow", pageNow);
			
			req.setAttribute("pageNow", pageNow);
			req.setAttribute("pageTotal", pageTotal);
			req.setAttribute("list", list);
			req.getRequestDispatcher("WEB-INF/page/empList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
