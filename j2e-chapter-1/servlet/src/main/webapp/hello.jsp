<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello JSP</title>
</head>
<body>
	Hello,MyServlet!!<br>
	<!-- 声明:声明成员变量、成员方法 -->
	声明: <%!int i = 100;
	   public String hello(){
		   return "hello";
	   }
	%>
	<br>
	<!-- 表达式:运行简单的算式、有返回值的方法 -->
	计算:i+100= <%=i+100 %>
	<br>
	调用hello(): <%=hello() %>
	<br>
	<!-- Java片段:原封不动的翻译到servlt的service方法中的代码 -->
	Java片段: <%out.println(i); %>
</body>
</html>