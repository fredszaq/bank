package com.excilys.formation.webservicers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.service.VirementService;
import com.excilys.formation.webservicers.VirementServiceRs;
import com.excilys.formation.webservicers.dto.bean.TransactionDTO;

/**
 * Interface VirementService.
 * 
 * @author excilys
 * 
 */
@Service("virementServiceRsImpl")
public class VirementServiceRsImpl implements VirementServiceRs {

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
