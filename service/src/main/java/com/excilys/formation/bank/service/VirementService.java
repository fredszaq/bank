package com.excilys.formation.bank.service;

import com.excilys.formation.bank.bean.Transaction;

/**
 * Interface VirementService.
 * 
 * @author excilys
 * 
 */
public interface VirementService {

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
