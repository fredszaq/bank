<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" language="java" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />

	<html lang="fr">
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/design.css" type="text/css"
	media="screen" />
<meta charset="utf-8" />
<title>Bank</title>
</head>
<body>
	<header>
		<table>
			<tr>
				<td id="logo"><a href="#"><img src="${pageContext.request.contextPath}/images/logo.svg"
						alt="BankRoot logo" /></a></td>
				<td id="title">This is the header</td>
				<td id="logininfo">
					<p>
						Logged as someone <br /> <a href="#">Disconnect</a>
					</p>
				</td>
			</tr>
		</table>
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
	<footer> 2012 - BankRoot </footer>
</body>
	</html>
</jsp:root>