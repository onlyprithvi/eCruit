<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<div class="small-12 small-centered columns">
	<h2>
		<img src="${base}/resource/images/user.png"> Edit User
	</h2>

	<form:form modelAttribute="user" method="post" action="">
		<c:if test="${message != null}">
			<div class="label alert register-error">${message}</div>
		</c:if>
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="user.firstname.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:input type="text" path="firstName" />
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="firstName" />
			</div>
		</div>
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="user.lastname.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:input type="text" path="lastName" />
				<form:input type="hidden" path="email" />
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="lastName" />
			</div>
		</div>
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="user.gender.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:radiobutton path="gender" value="M" />
				Male
				<form:radiobutton path="gender" value="F" />
				Female
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="gender" />
			</div>
		</div>		
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="user.contact.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:input type="text" path="contactNumber" />
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="contactNumber" />
			</div>
		</div>
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message code="user.desc.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:textarea path="description"></form:textarea>
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="description" />
			</div>
		</div>
		<div class="row">
			<div class="large-3 columns"></div>
			<div class="large-9 columns">
				<input type="submit" value="EDIT" class="button tiny" />
			</div>
		</div>
	</form:form>
</div>