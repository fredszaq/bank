package com.excilys.formation.bank.service;

import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.Transaction;

/**
 * Interface TransactionService.
 * 
 * @author excilys
 * 
 */
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
	 */
	void insert(Transaction transaction);

	/**
	 * Mise à jour d'une transaction.
	 * 
	 * @param transaction
	 *            : the transaction
	 * @param etat
	 *            : l'etat
	 */
	void update(Transaction transaction, Etat etat);

}
