<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>eCRUIT serVICE | Crawler</title>
<link rel="stylesheet" href="resource/css/foundation.css"></link>
<link rel="stylesheet" href="resource/css/main.css"></link>
</head>
<body>
	<div class="row">
		<div class="small-8 small-centered columns">
			<form:form>
				<fieldset>
					<legend>eCRUIT serVICE :Crawler</legend>
					<div class="label alert register-error">${message}</div>
					<div class="row">
						<div class="large-5 columns">
							<label class="right"><spring:message
									code="crawler.start.label" /></label>
						</div>
						<div class="large-3 columns">
							<input id="crawlerURL" value="" />
						</div>
						<div class="large-3 columns">
							<label> <a
								href='<c:url value="/a/crawl/${crawlerURL}" />'
								class="button tiny">DO CRAWL</a> 
							</label>
						</div>
					</div>					
				</fieldset>
			</form:form>
		</div>
	</div>
</body>
</html>