<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<div class="row">
	<div class="large-3 columns">
		<img src="${base}/resource/images/error.png">
	</div>
	<div class="large-9 columns">
		<h2>Error: ${errTitle}</h2>
		<h3>${errMessage}</h3>
	</div>
</div>