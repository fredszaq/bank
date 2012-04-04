package com.excilys.formation.webservice.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.service.OperationCarteService;
import com.excilys.formation.webservice.OperationCarteServiceWs;

/**
 * Interface OperationCarteService.
 * 
 * @author excilys
 * 
 */
public class OperationCarteServiceWsImpl implements OperationCarteServiceWs {

	@Autowired
	private OperationCarteService operationCarteService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Transaction createOperationCarte(String login,
			String compteDebiteurId, long montant, String libelle) {
		return operationCarteService.createOperationCarte(login,
				compteDebiteurId, montant, libelle);
	}
}
