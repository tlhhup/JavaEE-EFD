package com.lfl.test;

import java.util.UUID;

import com.lfl.util.Security;
import com.tools.encryption.MD5;

public class Test5 {
	public static void main(String[] args) {
		String str = "123123";
		String key = "woniu";
		String mw = Security.AES.encrypt(str, key);
		System.out.println(mw);
		System.out.println(Security.AES.decrypt(mw, key));
	}
}
