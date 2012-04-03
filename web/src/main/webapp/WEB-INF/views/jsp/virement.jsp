<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<fmt:setBundle basename="localization.Messages" />
	<h2><fmt:message key="virement.title" /></h2>

		<c:if test="${not empty param.error}">
				<div class="error">
					<fmt:message key="virement.error" />
				</div>
		</c:if>

	<c:url value="/secure/virement.form" var="virementURL">
	</c:url>
	<form action="${virementURL}"
		method="POST">
		<div class="box">
			<div>
				<label for="compteDebiteur"><fmt:message key="virement.compte.debiteur" /></label> <select
					name="compteDebiteur" id="compteDebiteur">
					<c:forEach var="compte" items="${comptes}">
						<option value="${compte.compteId }">${compte.compteId }</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<label for="compteCrediteur"><fmt:message key="virement.compte.crediteur" /></label><select
					name="compteCrediteur" id="compteCrediteur">
					<c:forEach var="compte" items="${comptes}">
						<option value="${compte.compteId }">${compte.compteId }</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<label for="montant"><fmt:message key="virement.montant" /></label> <input name="montant"
					type="number" id="montant"/>
			</div>

			<div>
				<label for="libelle"><fmt:message key="virement.libelle" /></label><input name="libelle"
					type="text" id="libelle"/>
			</div>


			<input type="submit" id="submit"/>

		</div>

	</form>


</jsp:root>

