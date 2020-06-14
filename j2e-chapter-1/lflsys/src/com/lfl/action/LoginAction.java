package com.lfl.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lfl.cache.SessionCache;
import com.lfl.dao.FuncDao;
import com.lfl.dao.ManagerDao;
import com.lfl.dao.ModelDao;
import com.lfl.dao.impl.FuncDaoImpl;
import com.lfl.dao.impl.ManagerDaoImpl;
import com.lfl.dao.impl.ModelDaoImpl;
import com.lfl.model.Func;
import com.lfl.model.Manager;
import com.lfl.model.Model;
import com.tools.encryption.MD5;

/**
 * 登录数据处理
 * @author waver
 *
 */
public class LoginAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面数据
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String saveManager = req.getParameter("saveManager");
		//获取验证码
		String yzcode = req.getParameter("yzcode");
		
		try {
			HttpSession session = req.getSession();
			//判断答案是否正确
			if( yzcode == null || !yzcode.equals(session.getAttribute("yzCode")) ){
				System.out.println("验证码错误！");
				//向页面转发用户名密码错误信息
				req.getRequestDispatcher("WEB-INF/page/login.jsp").forward(req, resp);
				return;
			}
			
			
			//以下是数据库操作
			ManagerDao md = new ManagerDaoImpl();
			Manager manager = md.queryManager(name, MD5.convert32(password));
			if( manager != null ){//合法管理员
				
//				if( manager.getIsLogin() == 1 ){//用户已经登录过了
//					req.setAttribute("loginInfo", "用户已在系统中！");
//					req.getRequestDispatcher("WEB-INF/page/login.jsp").forward(req, resp);
//					return;
//				}else{
//					//系统中没有该用户，将对应字段改为1
//					md.setIsLogin(1, manager.getId());
//				}
				
				//登录标识已经是1的用户再去遍历缓存，踢掉前一个登录的用户
				if( manager.getIsLogin() == 1 ){//用户已经登录过了

					Vector<HttpSession> vector = SessionCache.cache;
					Iterator<HttpSession> it = vector.iterator();
					while( it.hasNext() ){
						HttpSession loginSession = it.next();
						Manager loginManager = (Manager)loginSession.getAttribute("loginManager");
						if( manager.equals(loginManager) ){
							//当前登录的用户之前已经登录过了
							System.out.println("该用户已经登录过了！");
							it.remove();
							loginSession.invalidate();
						}
					}
					
				}
					
				//系统中没有该用户，将对应字段改为1
				md.setIsLogin(1, manager.getId());
				
				
				//唯一登录2
				//将登录用户绑定到session中
				session.setAttribute("loginManager", manager);
				SessionCache.cache.add(session);
				System.out.println(SessionCache.cache);
				
				
				ModelDao modelDao = new ModelDaoImpl();
				List<Model> modelList = modelDao.queryModelByID(manager.getId());
				
				FuncDao fd = new FuncDaoImpl();
				List<Func> funclist = fd.queryFuncUrl(manager.getId());
				
				
				
//				System.out.println("funclist: " + funclist);
//				System.out.println("modelList: " + modelList);
//				
				
				//构建权限数据类型Map<模块url, Map<功能url, 功能名称>>
				Map<String, Map<String, String>> qxMap = new HashMap<String, Map<String, String>>();
				for (Model model : modelList) {
					Map<String, String> funcMap = new HashMap<String, String>();
					for (Func func : funclist) {
						if( func.getModel_id() == model.getId() ){
							funcMap.put(func.getUrl(), func.getName());
						}
					}
					qxMap.put(model.getUrl(), funcMap);
				}
				
//				System.out.println(qxMap);
				//将功能与模块权限放入session
				session.setAttribute("modelMap", qxMap);
				//将模块权限放入session
				session.setAttribute("modelList", modelList);
				//将功能权限放入session
				session.setAttribute("funclist", funclist);
				
				
				//判断用户是否保存帐号密码
				if( saveManager != null ){
					//对用户名和密码重新编码
					name = URLEncoder.encode(name, "UTF-8");
					password = URLEncoder.encode(password, "UTF-8");
					 
					//创建cookie
					Cookie cookie = new Cookie("loginInfo", name + "|" + password);
					//设置cookie生命周期
					cookie.setMaxAge(6000);
					//设置缓存路径:当前路径
					cookie.setPath("/");
					
					//服务器响应的时候向客户端缓存写入一个cookie文件
					resp.addCookie(cookie);
					System.out.println("完成cookie");
				}
				
				
				//将登录成功的合法管理员绑定到request作用域中
				resp.sendRedirect("indexPage.action");
				return;
			}else{//不合法
				//向页面转发用户名密码错误信息
				req.getRequestDispatcher("WEB-INF/page/login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println("xxxxx");
			e.printStackTrace();
		}
	}
}
