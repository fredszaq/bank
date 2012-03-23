package com.excilys.formation.bank.service;

import com.excilys.formation.bank.bean.Compte;

public interface VirementService {

	void createVirement(Compte compteDebiteur, Compte compteCrediteur,
			double montant, String libelle);
}
