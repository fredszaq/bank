<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<fmt:setBundle basename="localization.Messages" />

	<h2><fmt:message key="carte.title" /></h2>


	<form action="${pageContext.request.contextPath}/secure/operationcarte.form"
		method="POST">
		<div class="box">
			<div>
				<label for="compteDebiteur"><fmt:message key="carte.numerocarte" /></label> <select
					name="compteDebiteur" id="compteDebiteur">
					<c:forEach var="compte" items="${comptes}">
						<option value="${compte.compteId}">${compte.numCarte}</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<label for="montant"><fmt:message key="carte.montant" /></label> <input name="montant"
					type="number" id="montant"/>
			</div>

			<div>
				<label for="libelle"><fmt:message key="carte.libelle" /></label><input name="libelle"
					type="text" id="libelle"/>
			</div>


			<input type="submit" id="submit"/>

		</div>

	</form>


</jsp:root>

