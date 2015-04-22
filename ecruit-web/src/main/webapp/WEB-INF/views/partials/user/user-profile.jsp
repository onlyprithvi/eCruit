<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3>User Profile: ${user.username}</h3>
${message}
<div class="row">
	<div class="small-6 columns">
		<div id="profilePic">
			
			<c:choose>
		<c:when test="${empty user.picLocation}">
		<a class="th"><img
				src="${pageContext.servletContext.contextPath}/resource/images/user.png"
				style="height: 200px;" /></a>
		</c:when>
		<c:otherwise>
		<a class="th"><img
				src="${pageContext.servletContext.contextPath}${user.picLocation}"
				style="height: 200px;" /></a>
		</c:otherwise>
			</c:choose>
			
		</div>
		<form:form modelAttribute="user" class="form-horizontal"
			action="uploadPhoto" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="large-8 columns">
					<label class="left">Change your profile picture</label>
					<form:input id="profilePic" path="profilePic" type="file" />
					<input id="pic" type="submit" Value="Change Profile Picture" class="button tiny"/>
				</div>
			</div>
			<form:hidden path="id" />
		</form:form>
	</div>
	<div class="small-6 columns">
		<div class="row">
			<div class="large-8 columns">
				<label  style="font-weight: bold;"><spring:message code="user.firstname.label" />${user.firstName}</label>
			</div>
		</div>
		<div class="row">

			<div class="large-8 columns">
				<label  style="font-weight: bold;"><spring:message code="user.lastname.label" />
					${user.lastName}</label>
			</div>
		</div>
		<div class="row">
			<div class="large-8 columns">
				<label  style="font-weight: bold;"><spring:message code="user.gender.label" />${user.gender}</label>
			</div>
		</div>
		<div class="row">
			<div class="large-8 columns">
				<label  style="font-weight: bold;"><spring:message code="user.contact.label" />${user.contactNumber}</label>

			</div>
		</div>
		<div class="row">
			<div class="large-8 columns">
				<label  style="font-weight: bold;"><spring:message code="user.email.label" />${user.email }</label>


			</div>
		</div>
		<div class="row">
			<div class="large-4 columns">
				<label  style="font-weight: bold;"><spring:message code="mailBox.number.label" />${user.mailBox.mNumber }</label>

			</div>
		</div>
		<div class="row">
			<div class="large-4 columns">
				<label  style="font-weight: bold;"><spring:message code="user.desc.label" /></label>
				${user.description }
			</div>
		</div>
		<a href='<c:url value="/u/user/edit/${user.id}" />'
			class="button tiny">Edit</a> <a href="changePassword"
			class="button tiny"> Change Password </a>
	</div>
</div>