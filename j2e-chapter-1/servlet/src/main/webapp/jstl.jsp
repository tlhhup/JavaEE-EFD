<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- taglib：引入标签库    uri：标签库地址   prefix：为标签库取别名，此名称可以在当前页面使用-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL常用标签</title>
</head>
<body>
	${name }是一个
	<!-- test:表示一个boolean值，var：指定一个变量存储test的计算结果
		 此变量可与通过EL表达式获取，如下代码就是通过这种方式构造一个if  else 结构
	 -->
	<c:if test="${age>25 }" var="is">
		小鲜肉
	</c:if>
	<c:if test="${!is }">
		老腊肉
	</c:if> 
	
	
	<!-- set标签演示 -->
	<!-- 在page作用域添加名称为a，值为hello的数据 -->
	<br><c:set var="a" value="hello"></c:set>
	${pageScope.a }<br>
	<!-- 在session作用域存储名称为b，值为hello的数据   var:指定存储的名称，value：指定存储的值
		scope：指定存储的作用域，不写则默认为page作用域
	 -->
	<c:set var="b" value="hello" scope="session"></c:set>
	${sessionScope.b }<br>
	
	<!-- 删除所有作用域中的name为a的数据 -->
	<c:remove var="a"/>
	<!-- 删除指定作用域中name为a的数据 -->
	<c:remove var="b" scope="session"/>
	${a }<br>
	${b }<br>
	
	<!-- choose标签 -->
	<c:choose>
		<c:when test="${age>25 }">太老</c:when>
		<c:when test="${age==25 }">刚刚好</c:when>
		<c:otherwise>太小</c:otherwise>
	</c:choose>
	<br>
	
	</body>
</html>