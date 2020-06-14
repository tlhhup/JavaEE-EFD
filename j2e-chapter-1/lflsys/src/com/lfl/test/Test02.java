package com.lfl.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.lfl.util.AuthCodeUtil;

public class Test02 {
	public static void main(String[] args) throws IOException {
		String answer = AuthCodeUtil.getAuthCode();
		BufferedImage bi = AuthCodeUtil.getAuthImg(answer);
		System.out.println(bi);
		ImageIO.write(bi, "png", new File("C:/a.png"));
		
		
	}
}
