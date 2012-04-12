<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:form="http://www.springframework.org/tags/form">
	<fmt:setBundle basename="localization.Messages" />
	<h2>
		<fmt:message key="virement.title" />
	</h2>

	<c:if test="${not empty param.error}">
		<div class="error">
			<fmt:message key="virement.error" />
		</div>
	</c:if>

	<c:url value="/secure/virement/${type}.html" var="virementURL">
	</c:url>
	<form:form action="${virementURL}" method="POST"
		commandName="virementValidator">
		<div class="box">
			<div>
				<label for="compteDebiteur"><fmt:message
						key="virement.compte.debiteur" /></label>
				<form:select path="compteDebiteur">
					<c:forEach var="compte" items="${comptes}">
						<form:option value="${compte.compteId }" />
					</c:forEach>
				</form:select>
			</div>

			<div>
				<label for="compteCrediteur"><fmt:message
						key="virement.compte.crediteur" /></label>
				<c:choose>
					<c:when test="${type.equals('interne')}">
						<form:select path="compteCrediteur">
							<c:forEach var="compte" items="${comptes}">
								<form:option value="${compte.compteId }" />
							</c:forEach>
						</form:select>
					</c:when>
					<c:otherwise>
						<form:input path="compteCrediteur" />
					</c:otherwise>
				</c:choose>
			</div>

			<div>
				<label for="montant"><fmt:message key="virement.montant" />&#160;<form:errors
						path="montant" /></label>
				<form:input path="montant" />
			</div>

			<div>
				<label for="libelle"><fmt:message key="virement.libelle" /></label>
				<form:input path="libelle" />
			</div>


			<input type="submit" id="submit" />

		</div>

	</form:form>
</jsp:root>

