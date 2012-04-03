package com.excilys.formation.bank.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.dao.OperationDAO;

/**
 * Implémentation de l'interface OperationDAO en utilisant Hibernate.
 * 
 * @author excilys
 * 
 */
@Repository("operationDAO")
public class OperationDAOHibernateImpl implements OperationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void delete(Operation operation) {
		sessionFactory.getCurrentSession().delete(operation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Operation getOperationById(Integer id) {
		return (Operation) sessionFactory.getCurrentSession().get(
				Operation.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void insert(Operation operation) {
		sessionFactory.getCurrentSession().save(operation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void update(Operation operation) {
		sessionFactory.getCurrentSession().merge(operation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<Operation> getOperationCarteFromCompteId(String compteId) {
		String query = "select operation from Compte compte join "
				+ "compte.operations operation where compte.id=:compteId "
				+ "and operation.transaction.transactionCategorie='CARTE' "
				+ "order by operation.transaction.dateValid ASC";
		return sessionFactory.getCurrentSession().createQuery(query)
				.setString("compteId", compteId).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final double getTotalOperationCarteFromCompteId(String compteId) {
		String query = "select sum(operation.montant) from Compte compte "
				+ "join compte.operations operation where compte.id=:compteId "
				+ "and operation.transaction.transactionCategorie='CARTE' ";
		List<?> resultList = sessionFactory.getCurrentSession()
				.createQuery(query).setString("compteId", compteId).list();
		Object result = resultList.get(0);
		return result == null ? 0 : (Long) result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<Operation> getOperationNonCarteFromCompteId(
			String compteId) {
		String query = "select operation from Compte compte join "
				+ "compte.operations operation where compte.id=:compteId "
				+ "and operation.transaction.transactionCategorie!='CARTE' "
				+ "order by operation.transaction.dateValid ASC";
		return sessionFactory.getCurrentSession().createQuery(query)
				.setString("compteId", compteId).list();
	}
}
