package com.excilys.formation.bank.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.dao.OperationDAO;

@Repository("operationDAO")
public class OperationDAOHibernateImpl implements OperationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void delete(Operation operation) {
		sessionFactory.getCurrentSession().delete(operation);
	}

	@Override
	public Operation getOperationById(Integer id) {
		return (Operation) sessionFactory.getCurrentSession().get(
				Operation.class, id);
	}

	@Override
	public void insert(Operation operation) {
		sessionFactory.getCurrentSession().save(operation);
	}

	@Override
	public void update(Operation operation) {
		sessionFactory.getCurrentSession().merge(operation);
	}

	@Override
	public List<Operation> getOperationCarteFromCompteId(String compteId) {
		String query = "select operation from Compte compte join compte.operations operation where compte.id=:compteId and operation.transaction.transactionCategorie.transactionCategorie='CARTE'";
		return sessionFactory.getCurrentSession().createQuery(query)
				.setString("compteId", compteId).list();
	}

	@Override
	public double getTotalOperationCarteFromCompteId(String compteId) {
		String query = "select sum(operation.montant) from Compte compte join compte.operations operation where compte.id=:compteId and operation.transaction.transactionCategorie.transactionCategorie='CARTE'";
		List<?> resultList = sessionFactory.getCurrentSession()
				.createQuery(query).setString("compteId", compteId).list();
		Object result = resultList.get(0);
		return result == null ? 0 : (Double) result;
	}

	@Override
	public List<Operation> getOperationNonCarteFromCompteId(String compteId) {
		String query = "select operation from Compte compte join compte.operations operation where compte.id=:compteId and operation.transaction.transactionCategorie.transactionCategorie!='CARTE'";
		return sessionFactory.getCurrentSession().createQuery(query)
				.setString("compteId", compteId).list();
	}
}
