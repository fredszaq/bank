package com.excilys.formation.bank.dao.impl;

import java.util.Date;
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
	@SuppressWarnings("unchecked")
	@Override
	public final List<Operation> getOperationCarteFromCompteId(String compteId,
			Date dateDebut, Date dateFin) {
		StringBuilder query = new StringBuilder();
		query.append("select operation from Compte compte join ")
				.append("compte.operations operation where compte.id=:compteId ")
				.append("and operation.transaction.transactionCategorie = 'CARTE' ")
				.append("and operation.transaction.dateValid between :dateDebut and :dateFin ")
				.append("and operation.transaction.etat = 'VALIDATED' ")
				.append("order by operation.transaction.dateValid DESC");
		return sessionFactory.getCurrentSession().createQuery(query.toString())
				.setString("compteId", compteId)
				.setDate("dateDebut", dateDebut).setDate("dateFin", dateFin)
				.list();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final long getTotalOperationCarteFromCompteId(String compteId) {

		StringBuilder query = new StringBuilder();
		query.append("select sum(operation.montant) from Compte compte ")
				.append("join compte.operations operation where compte.id=:compteId ")
				.append("and operation.transaction.transactionCategorie='CARTE' ")
				.append("and operation.transaction.etat = 'VALIDATED' ");
		Object result = sessionFactory.getCurrentSession()
				.createQuery(query.toString()).setString("compteId", compteId)
				.uniqueResult();
		return result == null ? 0 : (Long) result;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final List<Operation> getOperationNonCarteFromCompteId(
			String compteId, Date dateDebut, Date dateFin) {
		StringBuilder query = new StringBuilder();
		query.append("select operation from Compte compte join ")
				.append("compte.operations operation where compte.id=:compteId ")
				.append("and operation.transaction.transactionCategorie!='CARTE' ")
				.append("and operation.transaction.dateValid between :dateDebut and :dateFin ")
				.append("and operation.transaction.etat = 'VALIDATED' ")
				.append("order by operation.transaction.dateValid DESC");
		return sessionFactory.getCurrentSession().createQuery(query.toString())
				.setString("compteId", compteId)
				.setDate("dateDebut", dateDebut).setDate("dateFin", dateFin)
				.list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final List<Operation> getOperationFromCompteId(String compteId,
			Date dateDebut, Date dateFin) {
		StringBuilder query = new StringBuilder();
		query.append("select operation from Compte compte join ")
				.append("compte.operations operation where compte.id=:compteId ")
				.append("and operation.transaction.dateValid between :dateDebut and :dateFin ")
				.append("and operation.transaction.etat = 'VALIDATED' ")
				.append("order by operation.transaction.dateValid DESC");
		return sessionFactory.getCurrentSession().createQuery(query.toString())
				.setString("compteId", compteId)
				.setDate("dateDebut", dateDebut).setDate("dateFin", dateFin)
				.list();
	}

	@Override
	public final long getTotalOperationsNonValideesFromCompteId(String compteId) {

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
