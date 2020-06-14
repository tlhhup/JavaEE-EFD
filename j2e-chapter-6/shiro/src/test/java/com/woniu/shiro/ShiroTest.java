package com.woniu.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroTest {
	/**
	 * Shiro认证
	 */
	@Test
	public void test1() {
		/**
		 * 初始化SecurityManager的工厂类
		 * 传入参数：ini文件的路径
		 */
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//获取到SecurityManager对象
		SecurityManager instance = factory.getInstance();
		//SecurityUtils设置SecurityManager
		SecurityUtils.setSecurityManager(instance);
		/**
		 * 表示用户
		 */
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "12345");
		//登陆
		if(subject.isAuthenticated()) {
			System.out.println(subject.getPrincipal().toString() + "已登陆");
			return;
		}
		subject.login(token);
		System.out.println(subject.getPrincipal().toString() + "登陆成功");
		
		subject.logout();
		if(subject.getPrincipal()==null) {
			System.out.println("退出登陆");
		}
	}
	@Test
	public void test2() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_jdbc.ini");
		SecurityManager instance = factory.getInstance();
		SecurityUtils.setSecurityManager(instance);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("woniu1", "123456");
		//登陆
		if(subject.isAuthenticated()) {
			System.out.println(subject.getPrincipal().toString() + "已登陆");
			return;
		}
		subject.login(token);
		System.out.println(subject.getPrincipal().toString() + "登陆成功");
		
		subject.logout();
		if(subject.getPrincipal()==null) {
			System.out.println("退出登陆");
		}
	}
	@Test
	public void test3() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_permission.ini");
		SecurityManager instance = factory.getInstance();
		SecurityUtils.setSecurityManager(instance);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
		//登陆
		if(subject.isAuthenticated()) {
			System.out.println(subject.getPrincipal().toString() + "已登陆");
			return;
		}
		subject.login(token);
		//角色判断
		System.out.println("zhangsan:rol3角色" + subject.hasRole("role3"));
		System.out.println("zhangsan:rol1角色" + subject.hasRole("role1"));
		System.out.println("zhangsan:rol2角色" + subject.hasRole("role2"));
		//权限判断
		System.out.println(subject.isPermitted("system:create"));
		System.out.println(subject.isPermitted("mean:create"));
		
		if(subject.isPermitted("system:create")) {
			System.out.println("可以创建数据");
		} else {
			System.out.println("当前用户无操作权限，请联系管理员");
		}
	}
}
