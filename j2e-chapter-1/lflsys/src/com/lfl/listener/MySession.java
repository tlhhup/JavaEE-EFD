package com.lfl.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.lfl.cache.SessionCache;
import com.lfl.dao.ManagerDao;
import com.lfl.dao.impl.ManagerDaoImpl;
import com.lfl.model.Manager;

public class MySession implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		session.setAttribute("empListPageNow", 1);
		
		
		//将session添加到缓存
//		SessionCache.cache.add(session);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session销毁了。。。。。。");
		try {
			HttpSession session = se.getSession();
			
			Manager manager = (Manager)session.getAttribute("loginManager");
			if( manager != null ){
				ManagerDao md = new ManagerDaoImpl();
				md.setIsLogin(0, manager.getId());
			}
			
			//从缓存中删除session
			if( SessionCache.cache.contains(session) ){
				SessionCache.cache.remove(session);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
