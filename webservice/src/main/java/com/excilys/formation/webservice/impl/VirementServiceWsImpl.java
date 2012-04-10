package com.excilys.formation.webservice.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.service.VirementService;
import com.excilys.formation.dto.TransactionDTO;
import com.excilys.formation.webservice.VirementServiceWs;

/**
 * Interface VirementService.
 * 
 * @author excilys
 * 
 */
@WebService(endpointInterface = "com.excilys.formation.webservice.VirementServiceWs")
public class VirementServiceWsImpl implements VirementServiceWs {

	@Autowired
	private VirementService virementService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TransactionDTO createVirement(String login,
			String compteDebiteurId, String compteCrediteurId, long montant,
			String libelle) {
		Transaction transaction = virementService.createVirement(login,
				compteDebiteurId, compteCrediteurId, montant, libelle);
		TransactionDTO transactionDTO = new TransactionDTO.TransactionDTOBuilder()
				.withDateInit(transaction.getDateInit())
				.withDateValid(transaction.getDateValid())
				.withEtat(transaction.getEtat())
				.withLibelle(transaction.getLibelle())
				.withTransactionCategorie(transaction.getTransactionCategorie())
				.build();
		return transactionDTO;
	}
}
