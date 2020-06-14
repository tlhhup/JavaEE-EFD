package com.lfl.test;

import java.util.UUID;

import com.tools.encryption.MD5;

public class Test03 {
	public static void main(String[] args) {
		
		String pwd = "我是杜老板，我长得丑，但是我要找女朋友";
		String md5Str = MD5.convert32(pwd);
		System.out.println(md5Str);
		
		
		String str = UUID.randomUUID().toString();
		System.out.println(str.replaceAll("-", ""));
		
		
	}
}
