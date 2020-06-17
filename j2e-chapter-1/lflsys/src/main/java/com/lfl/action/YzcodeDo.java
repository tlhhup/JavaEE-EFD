package com.lfl.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lfl.util.AuthCodeUtil;

public class YzcodeDo extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//生成验证码到页面
		String answer = AuthCodeUtil.getAuthCode();
		BufferedImage bi = AuthCodeUtil.getAuthImg(answer);
		HttpSession session = req.getSession();
		//将答案放入session中以备检验
		session.setAttribute("yzCode", answer);
		ImageIO.write(bi, "png", resp.getOutputStream());
	}
}
