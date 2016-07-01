<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body><center>
	<form action="AddPublisher" method="post">
			<h1><label>请输入出版社信息</label></h1>
			<label>出版社编号</label><br>
			<input type="text" name="id" ><br>
			<label>出版社名称</label><br>
			<input type="text" name="name" ><br>
			<label>出版社电话</label><br>
			<input type="text" name="phone" ><br>
			<label>出版社邮编</label><br>
			<input type="text" name="zipcode" ><br>
			<label>出版社网站</label><br>
			<input type="text" name="website" ><br>
			<label>出版社城市</label><br>
			<input type="text" name="city" ><br>
			<label>出版社地址</label><br>
			<input type="text" name="addr" ><br>
			<input type="submit" value="提交"><br>
			</form>
</center></body>
</html>