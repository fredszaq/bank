<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<fmt:setBundle basename="localization.Messages" />
	<h2>
		<fmt:message key="compte.title" />
	</h2>
	<table>
		<tr>
			<th><fmt:message key="compte.type" /></th>
			<th><fmt:message key="compte.name" /></th>
			<th class="numeric"><fmt:message key="compte.solde" /></th>
		</tr>
		<tr>
			<td>${compte.compteType}</td>
			<td>${compte.compteId}</td>
			<td class="numeric"><fmt:formatNumber type="currency"
					currencyCode="EUR" value="${compte.solde}" /></td>
		</tr>
	</table>


	<h2>
		<fmt:message key="compte.operations" />
	</h2>

	<c:if test="${compte.hasCarte()}">
		<table>
			<tr>
				<th><a
					href="${pageContext.request.contextPath}/secure/detailCarte.html?id=${compte.compteId}"><fmt:message
							key="compte.carte.total" /></a></th>
				<td class="numeric"><fmt:formatNumber type="currency"
						currencyCode="EUR" value="${totalCarte }" /></td>
			</tr>
		</table>
	</c:if>

	<table>
		<tr>
			<th><fmt:message key="compte.operations.date" /></th>
			<th><fmt:message key="compte.operations.libelle" /></th>
			<th class="numeric"><fmt:message key="compte.operations.montant" /></th>
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
