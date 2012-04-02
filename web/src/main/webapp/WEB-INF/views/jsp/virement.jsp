<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">

	<h2>Effectuer un virement</h2>


	<form action="${pageContext.request.contextPath}/secure/virement.form"
		method="POST">
		<div class="box">
			<div>
				<label for="compteDebiteur">Compte débité</label> <select
					name="compteDebiteur" id="compteDebiteur">
					<c:forEach var="compte" items="${comptes}">
						<option value="${compte.compteId }">${compte.compteId }</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<label for="compteCrediteur">Compte crédité</label><select
					name="compteCrediteur" id="compteCrediteur">
					<c:forEach var="compte" items="${comptes}">
						<option value="${compte.compteId }">${compte.compteId }</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<label for="montant">Montant</label> <input name="montant"
					type="number" id="montant"/>
			</div>

			<div>
				<label for="libelle">Libellé</label><input name="libelle"
					type="text" id="libelle"/>
			</div>


			<input type="submit" />

		</div>

	</form>


</jsp:root>

