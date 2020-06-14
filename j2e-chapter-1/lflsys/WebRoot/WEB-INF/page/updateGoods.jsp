<%@ page language="java" import="java.util.*,com.lfl.model.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>修改产品</title>
	</head>
	<%
		Goods goods = (Goods)request.getAttribute("goods");
		List<Brand> brandList = (List<Brand>)request.getAttribute("brandList");
	%>
	<body>
		<form action="updateGoods.action" method="post">
			<input name="id" value="<%=goods.getId() %>" style="display: none;"><br/>
			产品编号:<input value="<%=goods.getGoodNo()%>" disabled="disabled"><br/>
			产品名称:<select name="brandID">
					<%
						for(Brand brand : brandList){
						pageContext.setAttribute("brand", brand);
					%>
<%-- 							<option value="<%=brand.getId()%>" <% if( goods.getBrand_id() == brand.getId() )out.print("selected='selected'"); %>><%=brand.getName() %></option> --%>
							<option value="<%=brand.getId()%>" ${ goods.brand_id == brand.id ?  "selected='selected'" : "" }><%=brand.getName() %></option>
					<%	
						}
					%>
				   </select><br/>
			一级分类:<select>
					<option>1</option>
				   </select><br/>
			二级分类:<select>
					<option>1</option>
				   </select><br/>
			进价:<input value="1111" ><br/>
			<input type="submit" value="保存" >
		</form>
	</body>
</html>
