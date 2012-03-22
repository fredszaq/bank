package com.excilys.formation.bank.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.Etat.EtatType;
import com.excilys.formation.bank.dao.EtatDAO;

@Repository("etatDAO")
public class EtatDAOHibernateImpl implements EtatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Etat getEtatByType(EtatType etatType) {
		String queryString = "from Etat where etatType = :etatType";
		return (Etat) sessionFactory.getCurrentSession()
				.createQuery(queryString)
				.setString("etatType", etatType.name()).uniqueResult();
	}

}
