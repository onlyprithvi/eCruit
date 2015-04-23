<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>
	<spring:message code="welcome.label" />
	${authenitcatedUser}
</h3>
<br>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<img src="${base}/resource/images/pie.jpg" style="height: 300px;"/>
