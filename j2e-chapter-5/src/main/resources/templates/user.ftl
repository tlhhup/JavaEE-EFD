<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
</head>
<body>
	<#-- 展现用户列表信息 -->
	<table>
		<thead>
			<tr>
				<th>姓名</th>
				<th>体重</th>
				<th>年龄</th>
				<th>生日</th>
				<th>是否可用</th>
			</tr>
		</thead>
		<tbody>
			<#list users as user>
			<tr>
				<td>${user.name}!</td>
				<td>${user.weight}</td>
				<td>${user.age}</td>
				<td>${user.birthday?date}</td>
				<td>${user.actived?then('可用','禁用')}</td>
			</tr>
			</#list>
		</tbody>
	</table>
</body>
</html>