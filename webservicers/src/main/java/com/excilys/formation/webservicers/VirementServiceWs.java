package com.excilys.formation.webservicers;

import com.excilys.formation.webservicers.dto.bean.TransactionDTO;

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
	TransactionDTO createVirement(String login, String compteDebiteurId,
			String compteCrediteurId, long montant, String libelle);
}
