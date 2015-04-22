<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eCRUIT serVICE</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#username").on("blur", function(){
			$.ajax({
				url: '<c:url value="/check-availability/username/" />' + $(this).val(),
				success: function(data) {
					if(data != '') {
						$('#error_username').html(data);
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="row">
		<div class="small-8 small-centered columns">
		<a href="?language=en">English</a> | <a href="?language=ne">नेपाली</a>
		
		
		
			<form:form modelAttribute="user" method="post" action="register">
				<fieldset>
					<legend>eCRUIT serVICE: Register</legend>
					
					
					<c:if test="${message != null}">
					<div class="label alert register-error">${message}</div>
					</c:if>
					
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.firstname.label" /></label>
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
							<label class="right"><spring:message code="user.lastname.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="text" path="lastName" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="lastName" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.gender.label" /></label>
						</div>
						<div class="large-6 columns">
							<label><form:radiobutton path="gender" value="M" /> Male</label>
							<label><form:radiobutton path="gender" value="F" /> Female</label>
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="gender" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.email.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="text" path="email" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="email" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.contact.label" /></label>
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
							<label class="right"><spring:message code="user.username.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="text" path="username" />
						</div>
						<div class="large-3 columns" id="error_username">
							<form:errors class="label alert" path="username" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.password.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="password" path="loginPassword" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="loginPassword" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.cpassword.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="password" path="confirmLoginPassword" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="confirmLoginPassword" />
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
						<div class="large-3 columns">
						</div>
						<div class="large-9 columns">
							<label>
								<input type="submit" value="REGISTER" class="button tiny" />
							</label>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</body>
</html>