package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.exception.TransactionNotFoundException;

/**
 * Interface TransactionDAO.
 * 
 * @author excilys
 * 
 */
public interface TransactionDAO {

	/**
	 * Obtention d'une transaction en fonction de son id.
	 * 
	 * @param transactionId
	 *            : the transaction id
	 * @return transaction
	 */
	Transaction getTransactionById(Integer transactionId)
			throws TransactionNotFoundException;

	/**
	 * Insertion d'une transaction.
	 * 
	 * @param transaction
	 *            : the transaction
	 */
	void insert(Transaction transaction);

	/**
	 * Mise à jour d'une transaction.
	 * 
	 * @param transaction
	 *            : the transaction
	 */
	void update(Transaction transaction);

}
