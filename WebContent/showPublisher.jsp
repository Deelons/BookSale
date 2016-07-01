<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=gb2312" import="com.booksale.module.*,java.util.*,javax.servlet.*"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

</head>
<body><center>
	<a href="login.jsp">Back to Login</a>
	<h1>出版社信息</h1>
	<%
		response.setCharacterEncoding("gb2312");
		request.setCharacterEncoding("gb2312");
		UserBeanDeal ubd = new UserBeanDeal();
		ArrayList al = ubd.getResult();
	%>
	
	<table border="1">
	<tr><th>PublisherNumber</th><th>PublisherName</th><th>PublisherPhone</th><th>ZipCode</th><th>WebSite</th><th>PublisherCity</th><th>PublisherAddress</tr>
	<%
		for (int i = 0;i < al.size();i ++ ) {
			UserBean ub = (UserBean)al.get(i);
			%> 
				<tr>
				<td><%=ub.getPublisherNumber() %></td>
				<td><%=ub.getPublisherName() %></td>
				<td><%=ub.getPublisherPhone() %></td>
				<td><%=ub.getZipCode() %></td>
				<td><%=ub.getWebsite() %></td>
				<td><%=ub.getPublisherCity() %></td>
				<td><%=ub.getPublisherAddress() %></td>
				</tr>
			<%
		}
	%>
	</table>
</center></body>
</html>