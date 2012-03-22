package com.excilys.formation.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.Etat.EtatType;
import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.dao.EtatDAO;
import com.excilys.formation.bank.dao.TransactionDAO;
import com.excilys.formation.bank.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private EtatDAO etatDAO;

	@Override
	public final void delete(Transaction transaction) {
		transactionDAO.delete(transaction);

	}

	@Override
	public final Transaction getTransactionById(Integer transactionId) {
		return transactionDAO.getTransactionById(transactionId);
	}

	@Override
	public final void insert(Transaction transaction) {
		transactionDAO.insert(transaction);
	}

	@Override
	public final void update(Transaction transaction, EtatType etatType) {
		Etat etat = etatDAO.getEtatByType(etatType);
		transaction.setEtat(etat);
		transactionDAO.update(transaction);
	}

}
