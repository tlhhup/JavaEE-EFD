package com.lfl.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lfl.util.AuthCodeUtil;

/**
 * 登录页面
 * @author waver
 *
 */
public class LoginPageAction extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			String info = null;
//			从客户端缓存中获取所有项目的cookie, 
			Cookie[] cookies = req.getCookies();
			if( cookies != null ){
				for (Cookie cookie : cookies) {
//					System.out.println("cookieName: " + cookie.getName() + " cookieVal: " + cookie.getValue());
//					if( "loginInfo".equals(cookie.getName()) ){//找到name对应的cookie
//						info = cookie.getValue();
//					}
				}
			}
//			System.out.println("info: " + info);
//			if( info != null ){
//				String name = info.split("\\|")[0];
//				String password = info.split("\\|")[1];
//				req.setAttribute("name", URLDecoder.decode(name, "UTF-8"));
//				req.setAttribute("password", URLDecoder.decode(password, "UTF-8"));
//			}
			
//			HttpSession session = req.getSession();
//			System.out.println("SID: " + session.getId());
			
			
			req.getRequestDispatcher("WEB-INF/page/login.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
