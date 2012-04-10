<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<fmt:setBundle basename="localization.Messages" />

	<div class="buttonRow">
		<c:url value="/secure/admin/comptes.html" var="urlAccounts" />
		<c:url value="/secure/admin/users.html" var="urlUsers" />
		<a class="button" href="${urlAccounts }"><fmt:message key="admin.accounts" /></a> <a class="button"
			href="${urlUsers }"><fmt:message key="admin.users" /></a>
	</div>

	<div id="adminContent">
		<tiles:insertAttribute name="adminContent" />
	</div>

</jsp:root>
