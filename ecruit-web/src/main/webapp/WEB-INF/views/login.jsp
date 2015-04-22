<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eCRUIT serVICE</title>
    </head>
    <body>
        <h1>Login Page!</h1>
        <a href="?language=en">English</a> | <a href="?language=ne">नेपाली</a>
        <c:if test="${error eq true}">
            <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
        </c:if>
        <form method="post" action="<c:url value='j_spring_security_check' />">
           <label><spring:message code="user.username.label" /> <input name="j_username" value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/> <br /></label>
            <label><spring:message code="user.password.label" /> <input type="password" name='j_password' /> </label><br />
                Remember me: <input type="checkbox" name="_spring_security_remember_me" /> <br />
                <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>" value="<c:out value="${_csrf.token}"/>"/>
           <label>	 <input type="submit" value="<spring:message code="user.login.label"/>" />
            <a href="<spring:url value="/register"></spring:url>" class="right"><spring:message code="user.register.label" /></a></label>	
        </form>
    </body>
</html>
