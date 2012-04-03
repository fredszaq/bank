package com.excilys.formation.bank.service;

import com.excilys.formation.bank.bean.Transaction;

public interface OperationCarteService {

	Transaction createOperationCarte(String login, String compteDebiteurId,
			double montant, String libelle);
}
