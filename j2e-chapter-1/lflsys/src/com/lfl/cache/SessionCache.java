package com.lfl.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

/**
 * session缓存
 * 	所有用户的session都在这里
 * @author waver
 *
 */
public class SessionCache {
	public static Vector<HttpSession> cache = new Vector<HttpSession>();
	
	
}
