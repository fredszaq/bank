package com.excilys.formation.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.dto.TransactionDTO;

@Component("Transaction2TransactionDTOConverter")
public class Transaction2TransactionDTOConverter implements
		Converter<Transaction, TransactionDTO> {

	@Override
	public TransactionDTO convert(Transaction transaction) {
		return new TransactionDTO.TransactionDTOBuilder()
				.withDateInit(transaction.getDateInit())
				.withDateValid(transaction.getDateValid())
				.withEtat(transaction.getEtat())
				.withLibelle(transaction.getLibelle())
				.withTransactionCategorie(transaction.getTransactionCategorie())
				.build();
	}
}
