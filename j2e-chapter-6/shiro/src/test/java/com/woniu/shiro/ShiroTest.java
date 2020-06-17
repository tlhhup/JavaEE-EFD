package com.woniu.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroTest {

	@Test
	public void testLogin() {
		//通过配置文件初始化SecurityManager对象
		Factory<SecurityManager> f = new IniSecurityManagerFactory("classpath:shiro.ini");
		//获取到SecurityManager对象
		SecurityManager sm = f.getInstance();
		//将SecurityManager对象绑定到SecurityUtils
		SecurityUtils.setSecurityManager(sm);
		//得到Subject
		Subject subject = SecurityUtils.getSubject();
		//创建用户名/密码验证Token
		UsernamePasswordToken token =
				new UsernamePasswordToken("zhang", "123");
		//判断用户是否已经登录
		if(subject.isAuthenticated()) {
			System.out.println(subject.getPrincipal()+" 已登录");
		} else {
			//进行登录
			subject.login(token);
			System.out.println(
					subject.getPrincipal()+" login successful");
		}
		//退出登录
		subject.logout();
		if(subject.getPrincipal()==null) {
			System.out.println("logout!!");
		}
	}

	@Test
	public void test3() {
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro_jdbc.ini");
		SecurityManager sm = factory.getInstance();
		SecurityUtils.setSecurityManager(sm);
		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token =
				new UsernamePasswordToken("zhang", "123");
		try {
			subject.login(token);
			System.out.println("登录成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("登录失败");
		}
		subject.logout();
	}
	@Test
	public void testPermission() {
		//获取subject,登录
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_permissions.ini");
		SecurityManager sm = factory.getInstance();
		SecurityUtils.setSecurityManager(sm);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token =
				new UsernamePasswordToken("zhang", "123");
		subject.login(token);
		//判断是否具有单个操作权限
		Assert.assertTrue(subject.isPermitted("user:create"));
		//判断是否具有所有的操作权限，全部满足则返回true
		Assert.assertTrue(
				subject.isPermittedAll("user:update","user:delete"));
		//检查是否具有某权限，没有则抛出异常
		subject.checkPermission("user:create");
		subject.checkPermissions(
				"user:update","user:delete","user:view");
	}
	@Test
	public void testRole() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_role.ini");
		SecurityManager sm = factory.getInstance();
		SecurityUtils.setSecurityManager(sm);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token =
				new UsernamePasswordToken("zhang", "123");
		subject.login(token);
		//判断是否具有对应角色
		Assert.assertTrue(subject.hasRole("role1"));
		//判断是否具有全部的角色，返回boolean数组，结果为顺序对传入角色的判断
		boolean[] hasRoles = subject.hasRoles(Arrays.asList("role1","role2","role3"));
		System.out.println(hasRoles[0]?"拥有角色role1":"没有role1角色");
		System.out.println(hasRoles[1]?"拥有角色role2":"没有role2角色");
		System.out.println(hasRoles[2]?"拥有角色role3":"没有role3角色");
		//检查单个角色，如果不具有角色，则抛出异常
		subject.checkRole("role1");
		subject.checkRole("role2");
		//检查用户是否具有多个角色，没有则会抛出异常
		subject.checkRoles("role1","role3");
	}
}
