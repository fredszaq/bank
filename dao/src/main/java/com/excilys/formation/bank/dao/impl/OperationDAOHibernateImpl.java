package com.excilys.formation.bank.dao.impl;

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
}
