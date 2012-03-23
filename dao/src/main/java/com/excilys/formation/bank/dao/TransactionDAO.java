package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.Transaction;

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
	void update(Transaction transaction);

}
