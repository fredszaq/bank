package com.excilys.formation.bank.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.dao.TransactionDAO;

/**
 * Implémentation de TransactionDAO via Hibernate
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
	public final void delete(Transaction transaction) {
		sessionFactory.getCurrentSession().delete(transaction);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Transaction getTransactionById(Integer transactionId) {
		return (Transaction) sessionFactory.getCurrentSession().get(
				Transaction.class, transactionId);
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
	public void update(Transaction transaction) {
		sessionFactory.getCurrentSession().merge(transaction);
	}

}
