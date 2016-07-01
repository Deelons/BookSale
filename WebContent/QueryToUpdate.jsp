<%@page import="com.booksale.module.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body>
	<center>
		<%
			response.setCharacterEncoding("gb2312");
			request.setCharacterEncoding("gb2312");
			String id1 = request.getParameter("id");
		
			UserBeanDeal ubd = new UserBeanDeal();
			ArrayList al = ubd.getAPublisher(id1);
			for(int i = 0;i < al.size();i ++ ) {
				UserBean ub = (UserBean)al.get(i);
			%> 
			<form action="UpdatePublisher?id1=<%= id1 %>" method="post">
			<h1><label>请输入出版社信息</label></h1>
			<label>出版社编号</label><br>
			<input type="text" name="id" value="<%= ub.getPublisherNumber() %>"><br>
			<label>出版社名称</label><br>
			<input type="text" name="name" value="<%= ub.getPublisherName() %>"><br>
			<label>出版社电话</label><br>
			<input type="text" name="phone" value="<%= ub.getPublisherPhone() %>"><br>
			<label>出版社邮编</label><br>
			<input type="text" name="zipcode" value="<%= ub.getZipCode() %>"><br>
			<label>出版社网站</label><br>
			<input type="text" name="website" value="<%= ub.getWebsite() %>"><br>
			<label>出版社城市</label><br>
			<input type="text" name="city" value="<%=ub.getPublisherCity() %>"><br>
			<label>出版社地址</label><br>
			<input type="text" name="addr" value="<%= ub.getPublisherAddress() %>"><br>
			<input type="submit" value="提交"><br>
			</form>
			<%
			
			}
		%>
	</center>
</body>
</html>