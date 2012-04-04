package com.excilys.formation.webservice;

import com.excilys.formation.bank.bean.Transaction;

/**
 * Interface VirementService.
 * 
 * @author excilys
 * 
 */
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
	Transaction createVirement(String login, String compteDebiteurId,
			String compteCrediteurId, long montant, String libelle);
}
