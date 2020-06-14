package com.woniu;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class ShiroTest {
	@Test
	public void test4() {
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:jdbc.ini");
		SecurityManager sm = factory.getInstance();
		SecurityUtils.setSecurityManager(sm);
		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken("woniu1", "123456");
		try {
			subject.login(token);
			System.out.println("µÇÂ¼³É¹¦");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("µÇÂ¼Ê§°Ü");
		}
		subject.logout();
	}
}
