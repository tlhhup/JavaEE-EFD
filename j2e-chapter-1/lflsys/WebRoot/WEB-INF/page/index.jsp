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
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		function deleteData(id){
	 		if(confirm("确定删除？")){
	 			location.href="deleteGoods.action?id="+id;
	 		}
	 	}
		
// 		window.onbeforeunload = function(){ 
// 			$.ajax({
// 				url:"logout.action"
// 			});
// 		}

		$(function(){
// 			setInterval(function() {
// 	 			$.ajax({
// 					url:"heart.action"
// 				});
// 			}, 2000);
		});


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
<%-- 					<div class="left"><img src="image/leftmenu.gif"><a href="indexPage.action">※库存管理※</a></div> --%>
<!-- 					<div class="left"><img src="image/leftmenu.gif"><a href="empListPage.action">※员工管理※</a></div> -->
			</div>
		</div>
		<div id="right" style="text-align: center;">
			<h1>库存信息</h1>
			<table border="1" width="80%" align="center">
				<tr>
					<td>产品编号</td>
					<td>产品名称</td>
					<td>一级分类</td>
					<td>二级分类</td>
					<td>进价</td>
					<td>售价</td>
					<td>保质期</td>
					<td>库存</td>
					<td>操作</td>
				</tr>
				<%
					List<Goods> list = (List<Goods>)request.getAttribute("goodsList");
					for(Goods goods : list){
				%>
					<tr>
			  			<td><% out.print(goods.getGoodNo()); %></td>
			  			<td><% out.print(goods.getName()); %></td>
			  			<td><%=goods.getFirstType()%></td>
			  			<td>2</td>
			  			<td>1</td>
			  			<td>2</td>
			  			<td>1</td>
			  			<td>2</td>
			  			<td>
			  				<a href="javascript:;" onclick="deleteData(<%=goods.getId()%>);">删除产品</a>
			  				&nbsp;&nbsp;&nbsp;
			  				<a href="updateGoodsPage.action?id=<%=goods.getId()%>" >修改产品</a>
			  			</td>
		  			</tr>
				<%		
					}
				%>
			</table>
		</div>
	</body>
</html>
