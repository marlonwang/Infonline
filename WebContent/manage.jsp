<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>管理专区</title>
	<link href="css/action.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="edit/jwysiwyg/jquery.wysiwyg.css" type="text/css" />
	<script type="text/javascript" src="edit/jquery/jquery-1.3.2.js"></script>
   	<script type="text/javascript" src="edit/jwysiwyg/jquery.wysiwyg.js"></script>
   	<style type="text/css">
   		#text{ width: 39px; height:200px; float: left;}
   		#preview{ width:700px; height:200px; float: left; font-family:宋体;}
   		#edit_left{ width:225px; float:left; }
   		#edit_right{ width:auto; float:left; margin-left: 15px;}
   		#editstyle{ width:739px; margin-top:20px; float: left;}
   		#preview table tr{ width:655px;}
   		#preview table tr th{ text-align: left; }
   		#preview_title{ width:120px;}
   		#preview_pusher{ width:60px;}
   		#preview_date{ width:150px;}
   		#preview_content{ width:370px;}
   	</style>
</head>
<body>
	<c:if test="${isadmin=='0' || isadmin==null }">
		<script type="text/javascript" >
			alert("你没有此权限,将返回发布页面");
			window.location="distribute.jsp";
		</script>
		<%-- <jsp:forward page="distribute.jsp"></jsp:forward> --%>
	</c:if>
	<div id="banner" style="background-image:url(img/bannergl.jpg)"></div>
	<div id="navi">
		<ul>
			<li><span><span class="enlarge">管</span>理专区</span></li>
			<li><a href="distribute.jsp">信息发布</a></li>
			<li><a href="default.jsp" target="_self">返回主页</a></li>
		</ul>
	</div>
	<div id="container">
	  <form action="InfoManage" method="post">
		<div id="contain_left">
			<ul><img src="img\li_hand.gif" alt="hand">&nbsp;选择管理版块:
				<li><input type="radio" name="block" value="book" checked="checked"/>图书信息</li>
				<li><input type="radio" name="block" value="machine"/>机器信息</li>
				<li><input type="radio" name="block" value="help"/>帮助信息</li>
				<li><input type="radio" name="block" value="service"/>服务信息</li>
			</ul>
			<ul><img src="img\li_hand.gif" alt="hand">&nbsp;选择操作类型:
				<li><input type="radio" name="func" value="slt" checked="checked"/>查询</li>
				<!-- <li><input type="radio" name="func" value="chg" />修改</li> -->
				<li><input type="radio" name="func" value="del" />删除</li>
			</ul>
			<ul>
				<li><input type="submit" name="confirm" value="提交"></li>
			</ul>
		</div>
		<div id="contain_line"></div>
		<div id="contain_right">
			<div>
				<div id="text">当前表中内容</div>
				<div id="preview">
					<table>
						<tr>
							<th id="preview_title">标题</th>
							<th id="preview_pusher">发布者</th>
							<th id="preview_date">发布时间</th>
							<th id="preview_content">内容</th>
						</tr>
						<c:forEach items="${comlist}" var="mylist">
						<c:choose>
						<c:when test="${kind=='book' }">
						<tr>
							<td id="preview_title"><c:out value="${mylist['b_name'] }"></c:out></td>
							<td id="preview_pusher"><c:out value="${mylist['b_pusher'] }"></c:out></td>
							<td id="preview_date"><fmt:formatDate value="${mylist['b_postime']}" type="both"/></td>
							<td id="preview_content"><c:out value="${mylist['b_describe'] }"></c:out></td>
						</tr>
						</c:when>
						<c:when test="${kind=='machine' }">
						<tr>
							<td id="preview_title"><c:out value="${mylist['m_title'] }"></c:out></td>
							<td id="preview_pusher"><c:out value="${mylist['m_pusher'] }"></c:out></td>
							<td id="preview_date"><fmt:formatDate value="${mylist['m_postime']}" type="both"/></td>
							<td id="preview_content"><c:out value="${mylist['m_text'] }"></c:out></td>
						</tr>
						</c:when>
						<c:when test="${kind=='help' }">
							<td id="preview_title"><c:out value="${mylist['h_title'] }"></c:out></td>
							<td id="preview_pusher"><c:out value="${mylist['h_pusher'] }"></c:out></td>
							<td id="preview_date"><fmt:formatDate value="${mylist['h_postime']}" type="both"/></td>
							<td id="preview_content"><c:out value="${mylist['h_text'] }"></c:out></td>
						</c:when>
						<c:when test="${kind=='service' }">
							<td id="preview_title"><c:out value="${mylist['s_kind'] }"></c:out></td>
							<td id="preview_pusher"><c:out value="${mylist['s_pusher'] }"></c:out></td>
							<td id="preview_date"><fmt:formatDate value="${mylist['s_postime']}" type="both"/></td>
							<td id="preview_content"><c:out value="${mylist['s_text'] }"></c:out></td>
						</c:when>
						</c:choose>	
						</c:forEach>
					</table>
				</div>	
			</div>
			<div id="editstyle">
				<div id="edit_left">
					<div>
						<span>标题: </span>
						<span><input type="text" width="25" name="mtitle"></span>
					</div>
					<div style="margin-top:3px;">
						<span>作者: </span>
						<span><input type="text" width="25" name="mauthor"></span>
					</div>
					<div style=" margin-top:20px;"><span>内容:</span></div>
					<div style="margin-top:30px; color:red;">提示：根据查询结果填写标题、作者再删除</div>
				</div>
				<div id="edit_right">
					<textarea name="newtext" id="wysiwyg"  rows="5" cols="60">
						文本区中可容纳无限数量的文本
					</textarea>
					<script type="text/javascript">
						$(function()
						{
							$('#wysiwyg').wysiwyg();
						});
					</script>
				</div>
			</div>
		</div>
	  </form>
	</div>
	<div id="footer">
		<div>Contact:marlonwang@163.com</div>
		<div>Copyright &copy; 2014-2015, marlonwang, All Rights Reserved</div>
	</div>	
</body>
</html>