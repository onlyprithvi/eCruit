<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border>
		<tr>
			<th>Name</th>
			<th>Industry</th>
			<th>Skills</th>
			<th>Education</th>
			<th>Experience</th>
			<th>Action</th>
		</tr>
		<tr>
			<form:form commandName="filter">
				<th><form:input path="${filter.name}" /></th>
				<th><form:input path="${filter.industry}" /></th>
				<th><form:input path="${filter.skills}" /></th>
				<th><form:input path="${filter.education}" /></th>
				<th><form:input path="${filter.experience}" /></th>
				<th><input type="submit" name="action" value="Save" /> <input
					type="submit" name="action" value="Apply" /></th>
			</form:form>
		</tr>

		<c:forEach items="${profiles}" var="profile">
			<tr>
				<td>${profile.name}</td>
				<td>${profile.industry}</td>
				<%-- <td><c:forEach items="${profile.skills}" var="skill">
						${skill};
					</c:forEach></td>
				<td><c:forEach items="${profile.education}" var="edu">
						${edu};
					</c:forEach></td>
				<td>${profile.experience}</td> --%>
				<td><a href="${profile.url}" target="_blank">View Linked
						Profile</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>