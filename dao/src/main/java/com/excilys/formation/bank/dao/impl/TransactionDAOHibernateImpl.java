package com.excilys.formation.bank.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.dao.TransactionDAO;
import com.excilys.formation.bank.exception.TransactionNotFoundException;

/**
 * Implémentation de TransactionDAO via Hibernate.
 * 
 * @author excilys
 * 
 */
@Repository("transactionDAO")
public class TransactionDAOHibernateImpl implements TransactionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Transaction getTransactionById(Integer transactionId)
			throws TransactionNotFoundException {
		Transaction transaction = (Transaction) sessionFactory
				.getCurrentSession().get(Transaction.class, transactionId);
		if (transaction == null) {
			throw new TransactionNotFoundException("transaction inconnu");
		}
		return transaction;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void insert(Transaction transaction) {
		sessionFactory.getCurrentSession().save(transaction);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void update(Transaction transaction) {
		sessionFactory.getCurrentSession().merge(transaction);
	}

}
