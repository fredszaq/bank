package com.excilys.formation.bank.service;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.exception.CompteNotFoundException;

/**
 * Interface OperationCarteService.
 * 
 * @author excilys
 * 
 */
@Validated
public interface OperationCarteService {

	/**
	 * Création d'une opération carte.
	 * 
	 * @param login
	 *            : login de l'utilisateur
	 * @param compteDebiteurId
	 *            : id du compte débiteur (doit avoir une carte et appartenir a
	 *            l'user)
	 * @param montant
	 *            : montant
	 * @param libelle
	 *            : libelle
	 * @return Transaction
	 */
	Transaction createOperationCarte(String login, String compteDebiteurId,
			@Min(value = 0) long montant, String libelle)
			throws CompteNotFoundException;
}
