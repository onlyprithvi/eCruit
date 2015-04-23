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
	<table>
		<tr>
			<th>Name</th>
			<th>Industry</th>
			<th>Skills</th>
			<th>Education</th>
			<th>Experience</th>
			<th>Action</th>
		</tr>
		

		<c:forEach items="${queries}" var="query">
			<tr>
				<td>${query.filterName}</td>
				<td>${query.industry}</td>
				<td><c:forEach items="${query.skills}" var="skill">
						${skill};
					</c:forEach></td>
				<td><c:forEach items="${query.educations}" var="edu">
						${edu};
					</c:forEach></td>
				<td>${query.minimumExperience}</td>
				<td><a href="query?id=${query.id}" target="_blank">Execute</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>