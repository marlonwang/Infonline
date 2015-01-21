<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>信息发布平台</title>
	<link href="css/main.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/func.js"></script>
</head>
<body>
	<div id="top_space">
		<script type="text/javascript">showtime();</script>
	</div>
	<div id="banner"></div>
	<div id="navi">
		<ul>
			<li>
			  <span>欢迎你:
			  	<c:choose>
			  		<c:when test="${name==null }">游客</c:when>
			  		<c:when test="${isadmin =='1'}">管理员</c:when>
			  		<c:otherwise>${name }</c:otherwise>
			  	</c:choose>
			  </span>
			</li>
			<li><a href="" target="#">首页</a></li>
			<li><a href="distribute.jsp">发布信息</a></li>
			<li><a href="manage.jsp">管理专区</a></li>
			<li><a href="login.jsp">用户登录</a></li>
			<li><a href="signup.jsp">我要注册</a></li>
			<li><a href="logout.jsp">注销</a></li>
		</ul>
	</div>
	<div id="container">
		<div id="book_cloumn">
			<div id="book_head">图书专区</div>
			<c:forEach items="${allbooks}" var="book">
			<div id="fb_title">
				<span>主题:</span>
				<span><c:out value="${book['b_name'] }"></c:out></span>
			</div>
			<div id="fb_author_style">
				<span><i>——&nbsp;by:&nbsp;&nbsp;</i><c:out value="${book['b_pusher'] }"></c:out></span>
				<span><fmt:formatDate value="${book['b_postime']}" type="both"/></span>
				<%-- <c:out value="${book['b_postime'] }"></c:out> --%>
			</div>
			<div><span><strong>内容:</strong></span>
				 <span><c:out value="${book['b_describe'] }"></c:out></span>
			</div>
			<div style="height:10px"></div>
			</c:forEach>
			
		</div>
		<div id="machine_cloumn">
			<div id="machine_head">电器专区</div>
			<c:forEach items="${allmachines }" var="machine">
			<div id="fb_title">
				<span>主题：</span>
				<span><c:out value="${machine['m_title'] }"></c:out></span>
			</div>
			<div id="fb_author_style">
				<span><i>——&nbsp;by:&nbsp;&nbsp;</i><c:out value="${machine['m_pusher'] }"></c:out></span>
				<span><fmt:formatDate value="${machine['m_postime']}" type="both"/></span>
			</div>
			<div>
				<span><strong>内容:</strong></span>
				<span><c:out value="${machine['m_text'] }"></c:out></span>
			</div>
			<div style="height:10px"></div>
			</c:forEach>
		</div>
		<div id="help_serv">
			<div id="help_cloumn">
				<div id="help_service_head">帮助信息</div>
				<c:forEach var="help" items="${allhelp }">
				<div id="fb_title">
					<span>主题：</span>
					<span><c:out value="${help['h_title'] }"></c:out></span>
				</div>
				<div id="fb_author_style">
					<span><i>——&nbsp;by:&nbsp;&nbsp;</i>
						  <c:out value="${help['h_pusher'] }"></c:out>
					</span>
					<span><fmt:formatDate value="${help['h_postime']}" type="both"/></span>
				</div>
				<div><span><strong>内容:</strong></span>
					 <span><c:out value="${help['h_text'] }"></c:out></span>
				</div>
				<div style="height:10px"></div>
				</c:forEach>
			</div>
			<div id="serv_cloumn">
				<div id="help_service_head">服务信息</div>
				<c:forEach var="service" items="${allservice }">
				<div id="fb_title">
					<span>主题：</span>
					<span><c:out value="${service['s_kind'] }"></c:out></span>
				</div>
				<div id="fb_author_style">
					<span><i>——&nbsp;by:&nbsp;&nbsp;</i>
						<c:out value="${service['s_pusher'] }"></c:out>
					</span>
					<span><fmt:formatDate value="${service['s_postime']}" type="both"/></span>
				</div>
				<div><span><strong>内容:</strong></span>
					 <span><c:out value="${service['s_text'] }"></c:out></span>
				</div>
				<div style="height:10px"></div>
				</c:forEach>
			</div>
		</div>
		
	</div>
	<div id="footer">
		<div>Contact:marlonwang@163.com</div>
		<div>Copyright &copy; 2014-2015, marlonwang, All Rights Reserved</div>
	</div>

</body>
</html>