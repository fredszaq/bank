<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<fmt:setBundle basename="localization.Messages" />
<h2>Resumé du compte</h2>
	<table>
		<tr>
			<th>Type de compte</th>
			<th>Nom du compte</th>
			<th class="numeric">Solde</th>
		</tr>
			<tr>
				<td>${compte.compteType}</td>
				<td><a href="${pageContext.request.contextPath}/secure/account.html?id=${compte.compteId}">${compte.compteId}</a></td>
				<td class="numeric"> <fmt:formatNumber type="currency" currencyCode="EUR" value="${compte.solde}" /></td>
			</tr>
	</table>  
	
	
	<h2>Opérations</h2>
	<table>
	<tr>
		<th>
			Date
		</th>
		<th>
			Libellé
		</th>
		<th>
			Montant
		</th>
	</tr>

	<!--<c:forEach var="operation" items="${compte.operations}" varStatus="loopStatus">
			<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
				<td>${operation.date}</td>
				<td>${operation.libelle}</td>
				<td class="numeric"> <fmt:formatNumber type="currency" value="${operation.montant}" /></td>
			</tr>
		</c:forEach> -->

	</table>
</jsp:root>
