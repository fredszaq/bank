package com.excilys.formation.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.excilys.formation.dto.TransactionDTO;

/**
 * Interface VirementServiceWs.
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
	TransactionDTO createVirement(@WebParam String login,
			@WebParam String compteDebiteurId,
			@WebParam String compteCrediteurId, @WebParam long montant,
			@WebParam String libelle);
}
