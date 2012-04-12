package com.excilys.formation.webservice.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.exception.CompteNotFoundException;
import com.excilys.formation.bank.service.VirementService;
import com.excilys.formation.dto.TransactionDTO;
import com.excilys.formation.webservice.VirementServiceWs;

/**
 * Interface VirementServiceWsImpl.
 * 
 * @author excilys
 * 
 */
@WebService(endpointInterface = "com.excilys.formation.webservice.VirementServiceWs")
public class VirementServiceWsImpl implements VirementServiceWs {

	@Autowired
	private VirementService virementService;

	@Autowired
	@Qualifier("Transaction2TransactionDTOConverter")
	private Converter<Transaction, TransactionDTO> transaction2TransactionDTOConverter;

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

		return transaction2TransactionDTOConverter.convert(transaction);
	}
}
