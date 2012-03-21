<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<fmt:setBundle basename="localization.Messages" />
	This is a secured page ! Only logged users can view this !
	<table>
		<tr>
			<th>Type de compte</th>
			<th>Nom du compte</th>
			<th class="numeric">Solde</th>
		</tr>
		<c:forEach var="compte" items="${comptes}" varStatus="loopStatus">
			<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
				<td>${compte.compteType}</td>
				<td><a href="${pageContext.request.contextPath}/secure/account.html?id=${compte.compteId}">${compte.compteId}</a></td>
				<td class="numeric"> <fmt:formatNumber type="currency" currencyCode="EUR" value="${compte.solde}" /></td>
			</tr>
		</c:forEach>
	</table> 
</jsp:root>