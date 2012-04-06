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
					currencyCode="EUR" value="${compte.solde / 100.0}" /></td>
		</tr>
	</table>
	<h2>
		<fmt:message key="compte.operations" />
	</h2>
	<div class="buttonRow">
		<c:forEach var="entry" items="${months}" varStatus="loopStatusUrl">
			<c:url value="/secure/account/${entry.key}/${compte.compteId}.html"
				var="accountURL" />
			<a href="${accountURL }"
				class="button${month == entry.key ? ' selected' :'' }"> <fmt:formatDate
					value="${entry.value}" pattern="MMM yyyy" />
			</a>
		</c:forEach>

	</div>
	<c:url value="/secure/account/${month}/${compte.compteId}.xls"
		var="urlXls" />
	<p>
		<a href="${urlXls }"><fmt:message key="compte.download_as_xls" /></a>
	</p>
	<c:if test="${compte.hasCarte()}">
		<c:url
			value="/secure/detailCarte/${month}/${compte.compteId}.html"
			var="detailCarteURL" />
		<table>
			<tr>
				<th><a href="${detailCarteURL}"><fmt:message
							key="compte.carte.total" /></a></th>
				<td class="numeric"><fmt:formatNumber type="currency"
						currencyCode="EUR" value="${totalCarte / 100.0 }" /></td>
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
						value="${operation.operationType=='DEBIT' ? - operation.montant / 100.0 : operation.montant /100.0}" /></td>
			</tr>
		</c:forEach>

	</table>
</jsp:root>
