<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	请选择地区：<select id="province" onchange="loadCity()">
				<option value="" selected="selected">请选择省</option>
			</select>
			<select id="city" onchange="loadArea()">
				<option value="">请选择城市</option>
			</select>
			<select id="area">
				<option value="">请选择区域</option>
			</select>
</body>
<script type="text/javascript">
	$(function(){
		loadProv();
	})
	/*加载省数据*/
	function loadProv(){
		$.ajax({
			url:"/addr/getProvence",
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.code=='0'){
					var proStr = '';
					$.each(data.data,function(i,item){
						proStr += '<option value="'+item.provinceid+'">'+item.province+'</option>';
					});
					$("#province").append(proStr);
					return;
				}
				alert(data.msg);
			}
		})
	}
	/*根据省id加载城市数据*/
	function loadCity(){
		var province = $("#province").val();
		$.ajax({
			url:"/addr/getCities",
			data:{"provinceId":province},
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.code=='0'){
					$("#city").empty();
					var cityStr = '';
					$.each(data.data,function(i,item){
						cityStr += '<option value="'+item.cityid+'">'+item.city+'</option>';
					});
					$("#city").append(cityStr);
					return;
				}
				alert(data.msg);
			}
		})
	}
	/*根据城市id加载地区数据*/
	function loadArea(){
		var cityid = $("#city").val();
		$.ajax({
			url:"/addr/getArea",
			type:"post",
			data:{"cityid":cityid},
			dataType:"json",
			success:function(data){
				if(data.code=='0'){
					$("#area").empty();
					var areaStr = '';
					$.each(data.data,function(i,item){
						areaStr += '<option value="'+item.areaid+'">'+item.area+'</option>';
					});
					$("#area").append(areaStr);
					return;
				}
				alert(data.msg);
			}
		})
	}
</script>
</html>