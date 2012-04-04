package com.excilys.formation.webservice;

import com.excilys.formation.bank.bean.Transaction;

/**
 * Interface OperationCarteService.
 * 
 * @author excilys
 * 
 */
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
	Transaction createOperationCarte(String login, String compteDebiteurId,
			long montant, String libelle);
}
