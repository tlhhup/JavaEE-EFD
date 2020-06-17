<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>My JSP 'addEmp.jsp' starting page</title>
		<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			function checkName(obj){
				//属性名称:值
// 				var stu = {name:"杜洲", age:18};
// 				$.ajax({
// 					url:"checkEmp.action?name=" + obj.value,
// 					type:"post",
// 					//成功之后的回调函数
// 					success:function(data){
// 						alert(12345);
// 						$("#msg").html(data);
// 					}
// 				});

// 				$.ajax({
// 					url:"checkEmp.action",
// 					type:"post",
// 					data:{name:obj.value},
// 					dataType:"json",
// 					success:function(data){
// 						$("#msg").html(data.msg);
// 					}
// 				});

// 				alert( document.getElementById("msg") );
// 				alert($("#msg"));
				
// 				alert( $("#msg").get(0) );
				
				
// 				var msgTag = document.getElementById("msg");
// 				$(msgTag).html("test");
				
			}
		</script>
	</head>
	
	<body>
		<form action="addEmp.action" method="post">
			员工名称:<input name="name" value="" onblur="checkName(this);"><span id="msg" style="color:red;"></span>
			<br/>
			<input type="submit" value="保存" >
		</form>
	</body>
</html>
