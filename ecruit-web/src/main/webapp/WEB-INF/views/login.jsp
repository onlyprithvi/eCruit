<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eCRUIT serVICE</title>
<link rel="stylesheet" href="resource/css/foundation.css"></link>
<link rel="stylesheet" href="resource/css/main.css"></link>
</head>
<body>
	<div class="row">
		<div class="small-4 small-centered columns">

			<a href="?language=en">English</a> | <a href="?language=ne">नेपाली</a>

			<form method="post"
				action="<c:url value='j_spring_security_check' />">
				<fieldset>
					<legend>
						<spring:message code="ecruit.login.label" />
					</legend>
					<c:if test="${error eq true}">
						<div class="label alert login-error">
							<p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
						</div>
					</c:if>					
					<div class="row">
						<div class="large-12 columns">
							<label><spring:message code="user.username.label" /><input type="text" name="j_username"
								id="j_username" value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>' />
							</label>
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							<label><spring:message code="user.password.label" /> <input
								type="password" name='j_password' /> </label><br />
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							Remember me: <input type="checkbox"
								name="_spring_security_remember_me" /> <br /> <input
								type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
								value="<c:out value="${_csrf.token}"/>" /> <label> <input
								type="submit" value="<spring:message code="user.login.label"/>" class="button tiny"/>
								<a href="<spring:url value="/register"></spring:url>"
								class="right"><spring:message code="user.register.label" /></a></label>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>
