package com.excilys.formation.bank.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.TransactionCategorie;
import com.excilys.formation.bank.bean.TransactionCategorie.TransactionCategorieType;
import com.excilys.formation.bank.dao.TransactionCategorieDAO;

@Repository("transactionCategorieDAO")
public class TransactionCategorieDAOHibernateImpl implements
		TransactionCategorieDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TransactionCategorie getTransactionCategorieByType(
			TransactionCategorieType categorieType) {
		String queryString = "from TransactionCategorie where transactionCategorieType = :categorieType";
		return (TransactionCategorie) sessionFactory.getCurrentSession()
				.createQuery(queryString)
				.setString("categorieType", categorieType.name())
				.uniqueResult();
	}

}
