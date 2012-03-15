<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:sec="http://www.springframework.org/security/tags">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" language="java" />
	<jsp:output doctype-root-element="html"
		doctype-system="about:legacy-compat" omit-xml-declaration="true" />

<fmt:setBundle basename="localization.Messages" />
	<html lang="${pageContext.response.locale.language}">
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
		<div id="title">This is the header</div>

		<c:if test="${pageContext['request'].userPrincipal != null}">
		<div id="logininfo">
			Logged as ${pageContext['request'].userPrincipal.name} <br /> <a href="#">Disconnect</a>
		</div>
		</c:if>

	</header>
	<aside>
		This is the menu
		<ul>
			<li>a menu item</li>
			<li>a menu item</li>
			<li>a menu item</li>
			<li>a menu item</li>
			<li>a menu item</li>
		</ul>
	</aside>
	<nav>
		<a href="#">vous</a> &gt; <a href="#">êtes</a> &gt; ici
	</nav>
	<div class="content">
		<tiles:insertAttribute name="body" />
	</div>
	<footer>
		2012 - BankRoot <br />
	</footer>
</body>
	</html>
</jsp:root>