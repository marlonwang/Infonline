<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册</title>
<style type="text/css">
	#top {margin-top:100px; color: red; font-size: 20px;}
	#image { width:480px; height:300px;
		background-image:url(img/sign_bg.png);}
	#form_table{width:300px; height:200px;margin-top: 55px; 
		margin-left:90px; border:0px; float:left;}
	#form_table tr td {font-family:黑体; text-align:center;}
</style>
</head>

<body style="width:480px; margin:0 auto;">
 	<div id="top"></div>
	<div id="image">
	<form action="SignUp" method="post">
		<table id="form_table">
			<tr>
				<td>用户名:</td>
				<td><input type="text" width="60px" height="40px" name="name" size="20"></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码:</td>
				<td><input type="password" width="60px" height="40px" name="pwd" size="20"></td>
			</tr>
			<tr>
				<td><input type="submit" value="注册" /></td>
				<td><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
	
	</div>
</body>
</html>