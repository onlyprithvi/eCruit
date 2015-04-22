<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<h2>
	<img src="${base}/resource/images/user.png"> Users
</h2>
<c:if test="${successMessage != null}">
	<div class="panel" style="background-color: green; color: white;">${successMessage}</div>
</c:if>
<c:if test="${errorMessage != null}">
	<div class="panel" style="background-color: red; color: white;">${errorMessage}</div>
</c:if>
<table style="width: 100%;">
	<thead>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Contact Number</th>
			<th>Gender</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user}</td>
				<td>${user.email}</td>
				<td>${user.contactNumber}</td>
				<td>${user.gender}</td>
				<td>${user.status.name}</td>				
			</tr>
		</c:forEach>
	</tbody>
</table>