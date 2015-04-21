<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-PostMan</title>

</head>
<body>
	<div class="row">
		<div class="small-4 small-centered columns">			
			<form method="post" action="<c:url value='j_spring_security_check'/>">
				<fieldset>					
					<c:if test="${error}">
						<div class="label alert login-error">Invalid login or
							password.</div>
					</c:if>
					<div class="row">
						<div class="large-12 columns">
							<label><input type="text" name="j_username"
								id="j_username" />
							</label>
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							<label> <input type="password"
								name="j_password" id="j_password" />
							</label>
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							<label>								
								<input type="submit" value="submit" class="button tiny" />								
							</label>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>