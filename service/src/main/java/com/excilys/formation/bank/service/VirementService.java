package com.excilys.formation.bank.service;

import com.excilys.formation.bank.bean.Transaction;

public interface VirementService {

	Transaction createVirement(String login, String compteDebiteurId,
			String compteCrediteurId, double montant, String libelle);
}
