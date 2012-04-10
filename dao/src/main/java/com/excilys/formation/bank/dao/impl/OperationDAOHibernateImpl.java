package com.excilys.formation.bank.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.dao.OperationDAO;
import com.excilys.formation.bank.exception.OperationNotFoundException;

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
	public final Operation getOperationById(Integer id)
			throws OperationNotFoundException {
		Operation operation = (Operation) sessionFactory.getCurrentSession()
				.get(Operation.class, id);
		if (operation == null) {
			throw new OperationNotFoundException("Operation inconnu");
		}
		return operation;
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
	@SuppressWarnings("unchecked")
	@Override
	public final List<Operation> searchOperationCarteFromCompteId(
			String compteId, Interval interval) {
		StringBuilder query = new StringBuilder();
		query.append("select operation from Compte compte join ")
				.append("compte.operations operation where compte.id=:compteId ")
				.append("and operation.transaction.transactionCategorie = 'CARTE' ")
				.append("and operation.transaction.dateValid between :dateDebut and :dateFin ")
				.append("and operation.transaction.etat = 'VALIDATED' ")
				.append("order by operation.transaction.dateValid DESC");
		return sessionFactory.getCurrentSession().createQuery(query.toString())
				.setString("compteId", compteId)
				.setDate("dateDebut", interval.getStart().toDate())
				.setDate("dateFin", interval.getEnd().toDate()).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final long searchTotalOperationCarteFromCompteId(String compteId,
			Interval interval) {

		StringBuilder query = new StringBuilder();
		query.append("select sum(operation.montant) from Compte compte ")
				.append("join compte.operations operation where compte.id=:compteId ")
				.append("and operation.transaction.transactionCategorie='CARTE' ")
				.append("and operation.transaction.dateValid between :dateDebut and :dateFin ")
				.append("and operation.transaction.etat = 'VALIDATED' ");
		Object result = sessionFactory.getCurrentSession()
				.createQuery(query.toString()).setString("compteId", compteId)
				.setDate("dateDebut", interval.getStart().toDate())
				.setDate("dateFin", interval.getEnd().toDate()).uniqueResult();
		return result == null ? 0 : (Long) result;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final List<Operation> searchOperationNonCarteFromCompteId(
			String compteId, Interval interval) {
		StringBuilder query = new StringBuilder();
		query.append("select operation from Compte compte join ")
				.append("compte.operations operation where compte.id=:compteId ")
				.append("and operation.transaction.transactionCategorie!='CARTE' ")
				.append("and operation.transaction.dateValid between :dateDebut and :dateFin ")
				.append("and operation.transaction.etat = 'VALIDATED' ")
				.append("order by operation.transaction.dateValid DESC");
		return sessionFactory.getCurrentSession().createQuery(query.toString())
				.setString("compteId", compteId)
				.setDate("dateDebut", interval.getStart().toDate())
				.setDate("dateFin", interval.getEnd().toDate()).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final List<Operation> searchOperationFromCompteId(String compteId,
			Interval interval) {
		StringBuilder query = new StringBuilder();
		query.append("select operation from Compte compte join ")
				.append("compte.operations operation where compte.id=:compteId ")
				.append("and operation.transaction.dateValid between :dateDebut and :dateFin ")
				.append("and operation.transaction.etat = 'VALIDATED' ")
				.append("order by operation.transaction.dateValid DESC");
		return sessionFactory.getCurrentSession().createQuery(query.toString())
				.setString("compteId", compteId)
				.setDate("dateDebut", interval.getStart().toDate())
				.setDate("dateFin", interval.getEnd().toDate()).list();
	}

	@Override
	public final long searchTotalOperationsNonValideesFromCompteId(
			String compteId) {

		StringBuilder query = new StringBuilder();
		query.append("select sum(operation.montant) from Compte compte ")
				.append("join compte.operations operation where compte.id=:compteId ")
				.append("and operation.transaction.etat = 'WAITING' ");
		Object result = sessionFactory.getCurrentSession()
				.createQuery(query.toString()).setString("compteId", compteId)
				.uniqueResult();
		return result == null ? 0 : (Long) result;
	}
}
