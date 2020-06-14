package com.woniu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class DBUtil {
	private static String driveNamen;
	private static String url;
	private static String user;
	private static String password;
	
	/**连接池对象*/
	private static DruidDataSource druid;
	private static Integer initialSize;
	private static Integer maxActive;
	private static Integer minIdle;
	private static Integer maxWait;
	
	static{
		
		try {
			String path = DBUtil.class.getResource(".").getPath();
			InputStream in = new FileInputStream(new File(path + "druid.properties"));
			Properties prop = new Properties();
			prop.load(in);
			
			druid = new DruidDataSource();
			
			//获取基本信息
			driveNamen = prop.getProperty("driveName");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
			
			//获取连接池信息
			initialSize = Integer.parseInt(prop.getProperty("initialSize"));
			maxActive = Integer.parseInt(prop.getProperty("maxActive"));
			minIdle = Integer.parseInt(prop.getProperty("minIdle"));
			maxWait = Integer.parseInt(prop.getProperty("maxWait"));
			
			//配置基本信息
			druid.setDriverClassName(driveNamen);
			druid.setUrl(url);
			druid.setUsername(user);
			druid.setPassword(Security.AES.decrypt(password, "woniu"));
			
			
			//连接池信息
			druid.setInitialSize(initialSize);
			druid.setMaxActive(maxActive);
			druid.setMinIdle(minIdle);
			druid.setMaxWait(maxWait);
			
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = druid.getConnection();
		} catch (SQLException e) {
			System.out.println("获取连接失败....");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void close( Connection conn ){
		try {
			if( conn != null )conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(DBUtil.getConnection());
	}
	
	
	
	
	
	
}
