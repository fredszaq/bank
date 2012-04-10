<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<fmt:setBundle basename="localization.Messages" />
	<h2>
		<fmt:message key="admin.liste_comptes"/>
	</h2>
	
	<table id="adminAccountList">
		<tr>
			<th><fmt:message key="comptes.type" /></th>
			<th><fmt:message key="comptes.name" /></th>
			<th><fmt:message key="comptes.taux_interet" /></th>
			<th><fmt:message key="comptes.num_carte" /></th>
		</tr>
		<c:forEach var="compte" items="${comptes}" varStatus="loopStatus">
			<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
				<td>${compte.compteType}</td>
				<td>${compte.compteId}</td>
				<td>${compte.tauxInteret}</td>
				<td>${compte.numCarte}</td>
			</tr>
		</c:forEach>
	</table>
</jsp:root>
