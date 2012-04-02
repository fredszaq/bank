package com.excilys.formation.bank.service;

public interface VirementService {

	void createVirement(String login, String compteDebiteurId,
			String compteCrediteurId, double montant, String libelle);
}
