package com.excilys.formation.bank.service;

import com.excilys.formation.bank.bean.Transaction;

/**
 * Interface OperationCarteService.
 * 
 * @author excilys
 * 
 */
public interface OperationCarteService {

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
			double montant, String libelle);
}
