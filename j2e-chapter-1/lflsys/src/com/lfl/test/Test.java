package com.lfl.test;

import java.io.UnsupportedEncodingException;

import com.lfl.model.Manager;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		String message = "杜老板";
//		String enMsg = URLEncoder.encode(message, "UTF-8");
//		System.out.println(enMsg);
//		
//		String deMsg = URLDecoder.decode(enMsg, "UTF-8");
//		System.out.println(deMsg);
		
//		Long.toHexString(1024252306035230640688265584249630640674)
//		System.out.println(Long.MAX_VALUE);
		Manager m1 = new Manager();
		Manager m2 = m1;
		m1.setName("abcd");
//		m2.setName("abcd");
		System.out.println(m1.equals(m2));
	}
}
