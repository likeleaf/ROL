<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="l" uri="http://tag.oneflyingleaf.com" %>
 <% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	request.setAttribute("ctx", basePath);
 %>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:choose><c:when test="${not empty param.title}">${param.title}</c:when><c:otherwise>leaf在线阅读网</c:otherwise></c:choose>
</title>
<script type="text/javascript" src="${ctx}/foreground/js/foreground.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/foreground/css/foreground.css"/>


</head>
