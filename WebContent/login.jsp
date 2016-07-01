<%@ page language="java" contentType="text/html; charset=gb2312" import="javax.servlet.http.*"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body>
	<%
		String info = request.getParameter("info");
		if(info != null) {
			%>
			<h1>用户名或密码错误！</h1><br>
			<%
		}
	%>
	<center>
	<h1>BookSale登陆系统</h1>
	<form action = "LoginDeal" method="post">
		用户名：<input type="text" name="username">	<br><br>
		密&nbsp;码：<input type="password" name = "passwd"><br><br>
		<input type="submit" value="登陆">
	</form>
	</center>
</body>
</html>