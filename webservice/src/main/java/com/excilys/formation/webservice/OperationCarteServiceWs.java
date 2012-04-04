package com.excilys.formation.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.excilys.formation.bank.bean.Transaction;

/**
 * Interface OperationCarteService.
 * 
 * @author excilys
 * 
 */
@WebService(serviceName = "operationCarteService")
public interface OperationCarteServiceWs {

	/**
	 * Création d'une opération carte.
	 * 
	 * @param login
	 *            : login de l'utilisateur
	 * @param compteDebiteurId
	 *            : id du compte débiteur
	 * @param montant
	 *            : montant
	 * @param libelle
	 *            : libelle
	 * @return Transaction
	 */
	Transaction createOperationCarte(@WebParam(name = "login") String login,
			@WebParam(name = "compteCrediteurId") String compteDebiteurId,
			@WebParam(name = "montant") long montant,
			@WebParam(name = "libelle") String libelle);
}
