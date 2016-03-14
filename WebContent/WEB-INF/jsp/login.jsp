<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
</head>
<body>
	<form action="/cxplay/user/login" method="post">
		<label for="username">用户名:</label>
		<input type="text" name="username" id="username">
		<br>
		<label for="password">密码:</label>
		<input type="password" name="password" id="password">
		<br>
		<input type="submit" value="登陆">
	</form>
</body>
</html>