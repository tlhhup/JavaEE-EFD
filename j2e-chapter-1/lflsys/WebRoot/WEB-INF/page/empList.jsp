<%@ page language="java" import="java.util.*,com.lfl.model.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>笠芙莱管理系统</title>
	
	  <meta name="keywords" content="keyword1,keyword2,keyword3">
	  <meta name="description" content="this is my page">
	  <meta name="content-type" content="text/html; charset=UTF-8">
	  <meta charset="UTF-8"/>
	</head>
	<style>
		 body,html{
	   	margin: 0;
	      width: 100%;
	      height: 100%;
	   }
	   #top{/*设置页面页眉的样式*/
	      width: 100%;
	      height: 8%;
	      background-image: url("image/headerbg.gif");
	      background-size: 100% 100%;
	      min-height: 80px;
	      min-width: 1000px;				
	   } 
	   #left{ /*设置左边栏的样式*/
	      width: 14%;
	      height: 100%;
	      background-image: url("image/leftbg.gif");
	      background-size: 100% 100%;
	      float: left;                     
	   }
	   #left-top{
	      width: 90%;
	      height: 50%;
	      margin-top: 20px;
	   }   
	   .left{
	      width:100%;
	      height: 8%;
	      color: #09c;
	      font-size: 16px;
	      text-align: center;
	      margin: 0 auto 0;
	   }  
	   #right{/*设置右边栏的样式*/
	     	width: 85.9%;
	      height:100%;
	      margin-left: 0.1%;
	      float: left;                    
	   }   
	</style>
	<script type="text/javascript">
		function deleteData(id){
	 		if(confirm("确定删除？")){
	 			location.href="deleteGoods.action?id="+id;
	 		}
	 	}
	</script>
	<body>
		<div id="top" style="padding-left: 10px;">
			欢迎:${ loginManager.nikeName } 
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="logout.action">退出系统</a>
		</div>
		<div id="left">
			<div id="left-top">
				<c:forEach items="${ sessionScope.modelList }" var="model">
					<div class="left"><img src="image/leftmenu.gif"><a href="/lflsys${ model.url }">※${ model.name }※</a></div>
				</c:forEach>
<!-- 					<div class="left"><img src="image/leftmenu.gif"><a href="indexPage.action">※库存管理※</a></div> -->
<!-- 					<div class="left"><img src="image/leftmenu.gif"><a href="empListPage.action">※员工管理※</a></div> -->
			</div>
		</div>
		<div id="right" style="text-align: center;">
			<h1>
				员工信息 &nbsp;&nbsp;
				<c:if test="${ sessionScope.modelMap['/empListPage.action']['/addEmpPage.action'] != null }">
					<a href="addEmpPage.action">${sessionScope.modelMap['/empListPage.action']['/addEmpPage.action']}</a>
				</c:if>
			</h1>
			<table border="1" width="80%" align="center">
				<tr>
					<td>id</td>
					<td>员工编号</td>
					<td>名称</td>
					<td>性别</td>
					<td>年龄</td>
					<td>部门</td>
					<td>岗位</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${ list }" var="emp">
					<tr>
						<td>${ emp.id }</td>
						<td>${ emp.empNo }</td>
						<td>${ emp.name }</td>
						<td>${ emp.sex == 0 ? "女" : "男" }</td>
						<td>${ emp.age }</td>
						<td>${ emp.dName }</td>
						<td>${ emp.jName }</td>
						<td>
							<a href="javascript:;" onclick="">删除</a>
			  				&nbsp;&nbsp;&nbsp;
			  				<a href="" >修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<a href="empListPage.action?pageDir=up">上一页</a>
			&nbsp;&nbsp;&nbsp;
			<c:forEach begin="1" end="${ pageTotal }" var="pagination">
				<c:if test="${ pageNow == pagination }">
					<a href="empListPage.action?pagination=${ pagination }" style="color: red;">${ pagination }</a>&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${ pageNow != pagination }">
					<a href="empListPage.action?pagination=${ pagination }">${ pagination }</a>&nbsp;&nbsp;&nbsp;
				</c:if>
			</c:forEach>
			<a href="empListPage.action?pageDir=down">下一页</a>
		</div>
	</body>
</html>
