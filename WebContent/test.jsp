<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ip 地址</title>
</head>
<body>
	<%!public String getIpAddr(HttpServletRequest request) {  
    String ip = request.getHeader("x-forwarded-for");     
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
        ip = request.getHeader("Proxy-Client-IP");     
    }     
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
        ip = request.getHeader("WL-Proxy-Client-IP");     
    }     
    if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("X-Real-IP");
    }
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
        ip = request.getRemoteAddr();     
    }     
    return ip;     
	}%>
	<%String ip=getIpAddr(request);
		response.getWriter().write(ip);
	%>
</body>
</html>