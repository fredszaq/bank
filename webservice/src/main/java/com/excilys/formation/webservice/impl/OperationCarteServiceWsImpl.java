package com.excilys.formation.webservice.impl;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.webservice.OperationCarteServiceWs;

/**
 * Interface OperationCarteService.
 * 
 * @author excilys
 * 
 */
public class OperationCarteServiceWsImpl implements OperationCarteServiceWs {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Transaction createOperationCarte(String login,
			String compteDebiteurId, long montant, String libelle) {
		return null;
	}
}
