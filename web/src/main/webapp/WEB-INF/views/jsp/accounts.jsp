<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<fmt:setBundle basename="localization.Messages" />
	<h2><fmt:message key="comptes.title" /></h2>
	<table id="accountList">
		<tr>
			<th><fmt:message key="comptes.type" /></th>
			<th><fmt:message key="comptes.name" /></th>
			<th class="numeric"><fmt:message key="comptes.solde" /></th>
			<th class="numeric"><fmt:message key="comptes.soldeprevisionnel" /></th>
		</tr>
		<c:forEach var="compte" items="${comptes}" varStatus="loopStatus">
			<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
				<td>${compte.compteType}</td>
				<c:url value="/secure/account.html" var="accountURL">
					<c:param name="id" value="${compte.compteId}"/>
					<c:param name="month" value="0"/>
				</c:url>
				<td><a href="${accountURL}">${compte.compteId}</a></td>
				<td class="numeric" id="solde_${compte.compteId}"> <fmt:formatNumber type="currency" currencyCode="EUR" value="${compte.solde/100.0}" /></td>
				<td class="numeric" id="solde_${compte.compteId}"> <fmt:formatNumber type="currency" currencyCode="EUR" value="${soldesPrevisionnels[compte.compteId]/100.0}" /></td>
			</tr>
		</c:forEach>
	</table> 
</jsp:root>
