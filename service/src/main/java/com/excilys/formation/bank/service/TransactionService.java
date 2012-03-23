package com.excilys.formation.bank.service;

import com.excilys.formation.bank.bean.Etat.EtatType;
import com.excilys.formation.bank.bean.Transaction;

public interface TransactionService {

	/**
	 * Obtention d'une transaction en fonction de son id.
	 * 
	 * @param transactionId
	 *            : the transaction id
	 * @return transaction
	 */
	Transaction getTransactionById(Integer transactionId);

	/**
	 * Insertion d'une transaction.
	 * 
	 * @param transaction
	 *            : the transaction
	 * @return boolean
	 */
	void insert(Transaction transaction);

	/**
	 * Mise à jour d'une transaction.
	 * 
	 * @param transaction
	 *            : the transaction
	 * @return boolean
	 */
	void update(Transaction transaction, EtatType etatType);

}
