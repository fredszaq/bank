package com.excilys.formation.bank.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.OperationComptable;
import com.excilys.formation.bank.bean.OperationComptable.OperationComptableType;
import com.excilys.formation.bank.dao.OperationComptableDAO;

@Repository("operationComptableDAO")
public class OperationComptableDAOImpl implements OperationComptableDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public OperationComptable getOperationComptableByType(
			OperationComptableType operationComptableType) {

		String queryString = "from OperationComptable where operationComptableType = :operationComptableType";
		return (OperationComptable) sessionFactory
				.getCurrentSession()
				.createQuery(queryString)
				.setString("operationComptableType",
						operationComptableType.name()).uniqueResult();
	}
}
