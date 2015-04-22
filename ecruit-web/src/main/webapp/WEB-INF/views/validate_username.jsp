<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${error}">
<span id="username.errors" class="label alert">Username already taken</span>
</c:if>