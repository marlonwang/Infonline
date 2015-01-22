<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>用户登录</title>
<style type="text/css">
	#top {margin-top:2px;}
	#main{background-image: url(img/login_bg.jpg);
			width:950px;height:618px;}
	#main_image{margin-top: 230px;margin-left:245px;
			width:412px;height:195px; float:left;}
	#form_table{width:300px;height:160px;margin-left:56px;
			margin-top:30px;}
	#form_table_td{text-align:center;}
	
	#form_table tr td {font-family:黑体;}

	/*login_bg 950*618  inner: 412*195  up 231 left 247*/
</style>
</head>

<body style="width:950px; margin:0 auto">
	<div id="top"></div>
	<div id="main">
		<div id="main_image">
			<form action="SignIn" method="post">
				<table id="form_table">
					<tr>
						<td>用户名：</td>
						<td><input type="text" width="60px" height="30px" name="name"></td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;码：</td>
						<td><input type="password" width="60px" height="30px" name="pwd"></td>
					</tr>
					<tr>
						<td id="form_table_td"><input type="submit" value="提交" /></td>
						<td id="form_table_td">
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>