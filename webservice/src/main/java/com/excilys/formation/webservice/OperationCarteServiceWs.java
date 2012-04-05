package com.excilys.formation.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.excilys.formation.bank.bean.Transaction;

/**
 * Interface OperationCarteService.
 * 
 * @author excilys
 * 
 */
@WebService
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
	@WebMethod
	Transaction createOperationCarte(@WebParam(name = "login") String login,
			@WebParam(name = "compteDebiteurId") String compteDebiteurId,
			@WebParam(name = "montant") long montant,
			@WebParam(name = "libelle") String libelle);
}
