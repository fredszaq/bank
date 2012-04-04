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
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/favicon.ico" />
<meta charset="utf-8" />
<title>BankRoot</title>
</head>
<body>
	<header>
		<div id="logo">
			<a href="${pageContext.request.contextPath}"><img
				src="${pageContext.request.contextPath}/images/logo.svg"
				alt="BankRoot logo" /></a>
		</div>
		<h1>
			<tiles:insertAttribute name="title" />
		</h1>
		<div id="logininfo">
			<c:choose>
				<c:when test="${pageContext['request'].userPrincipal != null}">
					<fmt:message key="baselayout.loggedas">
						<fmt:param
							value="${pageContext['request'].userPrincipal.principal.firstName} ${pageContext['request'].userPrincipal.principal.lastName}" />
					</fmt:message>
					<br />
					<a
						href="${pageContext.request.contextPath}/j_spring_security_logout"><fmt:message
							key="baselayout.disconnect" /></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/login.html"><fmt:message
							key="baselayout.login" /></a>
				</c:otherwise>
			</c:choose>
		</div>


	</header>
	<aside>
		<ul>
			<li><a href="${pageContext.request.contextPath}/"><fmt:message
						key="menu.accueil" /></a></li>
			<c:if test="${not empty pageContext.request.userPrincipal}">
				<c:forEach var="role"
					items="${pageContext['request'].userPrincipal.principal.authorities}">
					<c:if test="${role.authority == 'ROLE_ADMIN' }">
						<c:set scope="page" var="isAdmin" value="true" />
					</c:if>
				</c:forEach>

				<li><a
					href="${pageContext.request.contextPath}/secure/accounts.html"><fmt:message
							key="menu.accounts" /></a></li>
				<li><a
					href="${pageContext.request.contextPath}/secure/virement.html"><fmt:message
							key="menu.virement" /></a></li>
				<li><a
					href="${pageContext.request.contextPath}/secure/operationcarte.html"><fmt:message
							key="menu.carte" /></a></li>
				<c:if test="${pageScope.isAdmin }">
					<li><a
						href="${pageContext.request.contextPath}/secure/admin/admin.html"><fmt:message
								key="menu.admin" /></a></li>
				</c:if>
			</c:if>
		</ul>

	</aside>

	<!--<nav>
		<a href="#">vous</a> &gt; <a href="#">êtes</a> &gt; ici
	</nav>  -->
	<div class="content">
		<tiles:insertAttribute name="body" />
	</div>
	<footer>
		2012 - BankRoot <br />
	</footer>
</body>
	</html>
</jsp:root>
