<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>信息发布</title>
	<link href="css/action.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="edit/jwysiwyg/jquery.wysiwyg.css" type="text/css" />
	<script type="text/javascript" src="edit/jquery/jquery-1.3.2.js"></script>
   	<script type="text/javascript" src="edit/jwysiwyg/jquery.wysiwyg.js"></script>
</head>
<body>
	<c:if test="${name==null }">
		<jsp:forward page="login.jsp"></jsp:forward>
	</c:if>
	<div id="banner"></div>
	<div id="navi">
		<ul>
			<li><span><span class="enlarge">信</span>息发布</span></li>
			<li><a href="manage.jsp">管理专区</a></li>
			<li><a href="default.jsp" target="_self">返回主页</a></li>
		</ul>
	</div>
	<div id="container">
		<form action="InfoPublish" method="post">
		<div id="contain_left">
			<ul><img src="img\li_hand.gif" alt="hand">&nbsp;选择发布版块:
				<li><input type="radio" name="column" value="book" checked="checked"/>图书信息</li>
				<li><input type="radio" name="column" value="machine"/>机器信息</li>
				<li><input type="radio" name="column" value="help"/>帮助信息</li>
				<li><input type="radio" name="column" value="service"/>服务信息</li>
			</ul>
			<ul>
				<li>
					<!-- <input type="button" name="confirm" value="提交" 
						onclick="javascript:location.href='InfoPublish'"> -->
					<input type="submit" value="提交">
				</li>
			</ul>
		</div>
		<div id="contain_line"></div>

		<noscript>Enable JavaScript to use WYSIWYG features.</noscript>

		<div id="contain_right">
			<div style="margin-top:20px;">
				<span>标题: </span>
				<span><input type="text" width="25" name="title"></span>
			</div>
			<div style="margin-top:3px;">
				<span>作者: </span>
				<span><input type="text" width="25" name="author" value="${name }"></span>
			</div>
			<div style="margin-top:10px; margin-bottom:5px;"><span>内容:</span></div>
			<textarea name="wysiwyg" id="wysiwyg" rows="18" cols="85">
				文本区中可容纳无限数量的文本
			</textarea>
		</div>
		</form>
   		<script type="text/javascript" src="js/func.js"></script>
    	<script type="text/javascript">editor();</script>
		
	</div>
	<div id="footer">
		<div>Contact:marlonwang@163.com</div>
		<div>Copyright &copy; 2014-2015, marlonwang, All Rights Reserved</div>
	</div>
</body>
</html>