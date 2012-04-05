package com.excilys.formation.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.excilys.formation.bank.bean.Transaction;

/**
 * Interface VirementService.
 * 
 * @author excilys
 * 
 */
@WebService
public interface VirementServiceWs {

	/**
	 * Création d'une opértion de virement.
	 * 
	 * @param login
	 *            : le login de l'utilisateur
	 * @param compteDebiteurId
	 *            : le compte débiteur
	 * @param compteCrediteurId
	 *            : le compte créditeur
	 * @param montant
	 *            : le montant
	 * @param libelle
	 *            : le libelle
	 * @return Transaction
	 */
	@WebMethod
	Transaction createVirement(@WebParam(name = "login") String login,
			@WebParam(name = "compteDebiteurId") String compteDebiteurId,
			@WebParam(name = "compteCrediteurId") String compteCrediteurId,
			@WebParam(name = "montant") long montant,
			@WebParam(name = "libelle") String libelle);
}
