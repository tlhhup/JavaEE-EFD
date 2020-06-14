package com.woniu.realm;

import java.sql.Connection;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.woniu.dao.UserDao;
import com.woniu.entity.Users;
import com.woniu.util.DBUtil;

public class MyJdbcRealm extends AuthorizingRealm{
	private UserDao userDao = new UserDao();
	
	//为当前登录成功的用户进行授权
	@Override	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String) principals.getPrimaryPrincipal(); //获取用户名
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            authorizationInfo.setRoles(userDao.getRoles(conn, username)); //设置角色
            authorizationInfo.setStringPermissions(userDao.getPermission(conn, username)); //设置权限            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorizationInfo;
	}
	//验证方法，用以验证用户信息，简单理解就是验证用户名与密码是否正确
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		String username = (String) token.getPrincipal(); // 获取用户名
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            Users user = userDao.getUsers(conn, username); // 仅仅是根据用户名查出的用户信息，不涉及到密码
            if (user != null) {
                AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                        user.getUsername(), user.getPassword(), "myJdbcRealm");
                return authcInfo;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
	}
}
