<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" language="java" />
	<jsp:output doctype-root-element="html"
		doctype-system="about:legacy-compat" omit-xml-declaration="true" />

	<html lang="${pageContext.response.locale.language}">
<fmt:setBundle basename="localization.Messages" />
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/design.css"
	type="text/css" media="screen" />
<meta charset="utf-8" />
<title>Bank</title>
</head>
<body>
	<header>
		<div id="logo">
			<a href="#"><img
				src="${pageContext.request.contextPath}/images/logo.svg"
				alt="BankRoot logo" /></a>
		</div>
		<div id="title">Login</div>

	</header>
	<div class="content">
		<c:if test="${not empty param.login_error}">
			<font color="red"> <fmt:message key="login.error">
					<fmt:param value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				</fmt:message>
			</font>
		</c:if>

		<form name="f" action="${'j_spring_security_check'}" method="POST">
			<div class="loginbox">
				<div>
					<label for="j_username"><fmt:message key="login.username" /></label>
				</div>
				<div>
					<input id="j_username" type="text" name="j_username"
						value="${SPRING_SECURITY_LAST_USERNAME}" />
				</div>
				<div>
					<label for="j_password"><fmt:message key="login.password" /></label>
				</div>
				<div>
					<input id="j_password" type="password" name='j_password' />
				</div>
				<div>
					<input name="submit" type="submit" /><input
						id="_spring_security_remember_me" type="checkbox"
						name="_spring_security_remember_me" /> <label
						for="_spring_security_remember_me"><fmt:message
							key="login.rememberme" /></label>
				</div>
			</div>
		</form>
	</div>
	<footer>
		2012 - BankRoot <br />
	</footer>
</body>
	</html>
</jsp:root>

