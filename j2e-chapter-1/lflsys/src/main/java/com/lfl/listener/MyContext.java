package com.lfl.listener;

import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import com.lfl.cache.SessionCache;
import com.lfl.dao.ManagerDao;
import com.lfl.dao.impl.ManagerDaoImpl;
import com.lfl.util.DBUtil;

public class MyContext implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		DBUtil.getConnection();
		//不知道下面这句有什么用？
//		sce.getServletContext().setAttribute("lmanager", new ArrayList<String>());
		
		try {
			ManagerDao md = new ManagerDaoImpl();
			md.setIsLogin(0, null);
			
			//开启一个线程，定期遍历session缓存，讲超时的session销毁
//			Timer timer = new Timer();
//			timer.schedule(new TimerTask() {
//				@Override
//				public void run() {
//					Vector<HttpSession> sessionCache = SessionCache.cache;
//					Iterator<HttpSession> it = sessionCache.iterator();
//					Integer firstTime = null;
//					while( it.hasNext() ) {
//						HttpSession session = it.next();
//						//判断当前session是否登录过
//						if( session.getAttribute("loginManager") == null )continue;
//						
//						Long sessionTime = (Long)session.getAttribute("heartTime");
//						System.out.println("sessionTime: " + sessionTime);
//						
//						//检查是否是第一个心跳解决时间差问题
//						if( sessionTime == null ){
//							firstTime = (Integer)session.getAttribute("firstTime");
//							if( firstTime == null ){
//								session.setAttribute("firstTime", 0);
//							}else{
//								firstTime++;
//								session.setAttribute("firstTime", firstTime);
//							}
//						}
//						firstTime = (Integer)session.getAttribute("firstTime");
//						if( firstTime > 1 ){
//							System.out.println("非法用户！,响应页面不写了。");
//							session.invalidate();
//							it.remove();
//							continue;
//						}
//						
//						//心跳验证
//						Long nowTime = System.currentTimeMillis();
//						if( sessionTime != null ){
//							if( nowTime - sessionTime > 10 * 1000 ){//session超时
//								System.out.println("session心跳超时。。。。。");
//								session.invalidate();
//								it.remove();
//							}
//						}
//						
////						Long nowTime = System.currentTimeMillis();
////						if( nowTime - sessionTime > 10 * 1000 ){
////							System.out.println("当前session超时。。。");
////						}
//					}
//				}
//			}, 1000, 2000);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
