package com.excilys.formation.bank.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.dao.CompteDAO;

/**
 * Hibernate implementation for the UserDAO interface.
 * 
 * @author excilys
 * 
 */
@Repository("compteDAO")
public class CompteDAOHibernateImpl implements CompteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Compte loadCompteById(String id) {
		return (Compte) sessionFactory.getCurrentSession()
				.get(Compte.class, id);
	}

	@Override
	public Compte loadCompteByUsernameAndCompteId(String username,
			String compteId) {
		String query = "select comptes from User user join user.comptes comptes where user.login=:login and comptes.id=:compteId";
		List<?> resultList = sessionFactory.getCurrentSession()
				.createQuery(query).setString("login", username)
				.setString("compteId", compteId).list();
		return resultList.isEmpty() ? null : (Compte) resultList.get(0);

	}
}
