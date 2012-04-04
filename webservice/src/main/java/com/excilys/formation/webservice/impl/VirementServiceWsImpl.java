package com.excilys.formation.webservice.impl;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.webservice.VirementServiceWs;

/**
 * Interface VirementService.
 * 
 * @author excilys
 * 
 */
public class VirementServiceWsImpl implements VirementServiceWs {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Transaction createVirement(String login,
			String compteDebiteurId, String compteCrediteurId, long montant,
			String libelle) {
		return null;
	}
}
