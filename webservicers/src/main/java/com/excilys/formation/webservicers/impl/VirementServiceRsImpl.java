package com.excilys.formation.webservicers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.exception.CompteNotFoundException;
import com.excilys.formation.bank.service.VirementService;
import com.excilys.formation.dto.TransactionDTO;
import com.excilys.formation.webservicers.VirementServiceRs;

/**
 * Interface VirementServiceRsImpl .
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
	 * 
	 * @throws CompteNotFoundException
	 */
	@Override
	public final TransactionDTO createVirement(String login,
			String compteDebiteurId, String compteCrediteurId, long montant,
			String libelle) {
		Transaction transaction;
		try {
			transaction = virementService.createVirement(login,
					compteDebiteurId, compteCrediteurId, montant, libelle);
		} catch (CompteNotFoundException e) {
			return null;
		}
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
