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
			<td>${compte.compteId}</td>
			<td class="numeric"><fmt:formatNumber type="currency"
					currencyCode="EUR" value="${compte.solde}" /></td>
		</tr>
	</table>


	<h2>Opérations</h2>

	<c:if test="${compte.hasCarte()}">
		<table>
			<tr>
				<th><a
					href="${pageContext.request.contextPath}/secure/detailCarte.html?id=${compte.compteId}">Total
						des operations carte :</a></th>
				<td class="numeric"><fmt:formatNumber type="currency"
						currencyCode="EUR" value="${totalCarte }" /></td>
			</tr>
		</table>
	</c:if>

	<table>
		<tr>
			<th>Date</th>
			<th>Libellé</th>
			<th class="numeric">Montant</th>
		</tr>

		<c:forEach var="operation" items="${operations}"
			varStatus="loopStatus">
			<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
				<td><fmt:formatDate value="${operation.transaction.dateInit}" /></td>
				<td>${operation.transaction.libelle}</td>
				<td
					class="numeric ${operation.operationType=='DEBIT' ? 'negative' : 'positive'}"><fmt:formatNumber
						type="currency" currencyCode="EUR"
						value="${operation.operationType=='DEBIT' ? - operation.montant : operation.montant}" /></td>
			</tr>
		</c:forEach>

	</table>
</jsp:root>
