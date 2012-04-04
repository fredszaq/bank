package com.excilys.formation.bank.dao.impl;

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Compte loadCompteByUsernameAndCompteId(String username,
			String compteId) {
		StringBuilder query = new StringBuilder();
		query.append("select comptes from User user join ")
				.append("user.comptes comptes where user.login=:login ")
				.append("and comptes.id=:compteId");
		return (Compte) sessionFactory.getCurrentSession()
				.createQuery(query.toString()).setString("login", username)
				.setString("compteId", compteId).uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void updateSolde(String compteId, long difference) {
		Compte compte = loadCompteById(compteId);
		compte.setSolde(compte.getSolde() + difference);
		sessionFactory.getCurrentSession().update(compte);

	}
}
