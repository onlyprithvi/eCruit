<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>eCRUIT serVICE</title>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet" href="${base}/resource/css/foundation.css"></link>
<link rel="stylesheet" href="${base}resource/css/main.css"></link>
</head>
<body>
	<div class="row">
		<div class="small-12 small-centered columns">
			<div class="icon-bar six-up"  style="background-color: #008AA1;">
			
				<a href="<c:url value="/dashboard" />" class="item">					
					<label><spring:message code="dashboard.label"/></label>
				</a> 
				<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
				<a href="<c:url value="/u/users" />" class="item"> 					
					<label><spring:message code="users.label"/></label>
				</a> 
				</security:authorize>	
				<a  href="<c:url value="/u/settings" />" class="item">
					<img src="${base}/resource/images/setting.png">
					<label><spring:message code="settings.label"/></label>
				</a> 			
				<a href="<c:url value="/j_spring_security_logout" />" class="item"> 
					<img src="${base}/resource/images/logout.png">
					<label><spring:message code="logout.label"/></label>
				</a>
			</div>
			<span style="float: right;margin-top:5px;"><a href="?language=en">English</a> | <a href="?language=ne">नेपाली</a></span>
			<div style="padding: 30px;">
				<jsp:include page="../partials/${partials}.jsp" />
			</div>
			<div class="small-12 small-centered columns">
				<span style="float: right">Powered by eCRUIT serVICE</span>
				<span style="text-align: center;">copyright © 2015</span>
			</div>
		</div>
	</div>
</body>
</html>