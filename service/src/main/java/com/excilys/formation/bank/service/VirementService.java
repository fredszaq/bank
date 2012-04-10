package com.excilys.formation.bank.service;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.exception.CompteNotFoundException;

/**
 * Interface VirementService.
 * 
 * @author excilys
 * 
 */
@Validated
public interface VirementService {

	/**
	 * Création d'une opértion de virement.
	 * 
	 * @param login
	 *            : le login de l'utilisateur
	 * @param compteDebiteurId
	 *            : le compte débiteur (doit appartenir a l'utilisateur)
	 * @param compteCrediteurId
	 *            : le compte créditeur (doit etre different du compte débiteur)
	 * @param montant
	 *            : le montant
	 * @param libelle
	 *            : le libelle
	 * @return Transaction
	 */
	Transaction createVirement(String login, String compteDebiteurId,
			String compteCrediteurId, @Min(value = 0) long montant,
			String libelle) throws CompteNotFoundException;
}
