<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:form="http://www.springframework.org/tags/form">
	<fmt:setBundle basename="localization.Messages" />

	<h2>
		<fmt:message key="carte.title" />
	</h2>
	<c:if test="${not empty param.error}">
		<div class="error">
			<fmt:message key="carte.error" />
		</div>
	</c:if>

	<c:url value="/secure/operationCarte.html" var="operationCarteURL">
	</c:url>
	<form:form action="${operationCarteURL}" method="POST" commandName="carteValidator">
		<div class="box">
			<div>
				<label for="compteDebiteur"><fmt:message
						key="carte.numerocarte" /></label> 
				<form:select path="compteDebiteur">
					<c:forEach var="compte" items="${comptes}">
						<form:option value="${compte.compteId}"/>
					</c:forEach>
				</form:select>
			</div>

			<div>
				<label for="montant"> <fmt:message key="carte.montant" />&#160;<form:errors path="montant"/></label> <form:input path="montant"/>
			</div>

			<div>
				<label for="libelle"><fmt:message key="carte.libelle" /></label><form:input path="libelle"/>

			</div>


			<input type="submit" id="submit" />

		</div>

	</form:form>


</jsp:root>

