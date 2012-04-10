<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<fmt:setBundle basename="localization.Messages" />
	<h2>
		<fmt:message key="admin.liste_users"/>
	</h2>
	
	<table id="adminUserList">
		<tr>
			<th><fmt:message key="admin.user.login" /></th>
			<th><fmt:message key="admin.user.first_name" /></th>
			<th><fmt:message key="admin.user.last_name" /></th>
			<th><fmt:message key="admin.user.address" /></th>
			<th><fmt:message key="admin.user.last_connection" /></th>
		</tr>
		<c:forEach var="user" items="${users}" varStatus="loopStatus">
			<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
				<td>${user.login}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.address}</td>
				<fmt:formatDate value="${user.lastConnection.toDate() }" type="both" var="dateLastConnection" />
				<td>${dateLastConnection}</td>
			</tr>
		</c:forEach>
	</table>
</jsp:root>
