<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	response.setStatus(404);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404 error</title>
</head>
<body>

	<center>
		<img src="${pageContext.servletContext.contextPath}/resource/images/4o4error.png" alt="Page not found  JSP!!!" >
		<%-- <img
			src="<spring:url value="resource/images/4o4error.png"  htmlEscape="true" />"
			alt="Page not found  JSP!!!" /> --%>
	
	<H2>${requestScope['javax.servlet.error.message']}</H2>
	<p>
		<button type=button onclick=window.location.href="<spring:url value="/dashboard" />">Home</button>
	</p>
	</center>
</body>
</html>