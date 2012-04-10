package com.excilys.formation.bank.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.dao.CompteDAO;
import com.excilys.formation.bank.exception.CompteNotFoundException;

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
	public final Compte getCompteById(String id) throws CompteNotFoundException {
		Compte compte = (Compte) sessionFactory.getCurrentSession().get(
				Compte.class, id);
		if (compte == null) {
			throw new CompteNotFoundException("Compte inconnu");
		}
		return compte;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Compte getCompteByUsernameAndCompteId(String username,
			String compteId) throws CompteNotFoundException {
		StringBuilder query = new StringBuilder();
		query.append("select comptes from User user join ")
				.append("user.comptes comptes where user.login=:login ")
				.append("and comptes.id=:compteId");
		Compte compte = (Compte) sessionFactory.getCurrentSession()
				.createQuery(query.toString()).setString("login", username)
				.setString("compteId", compteId).uniqueResult();
		if (compte == null) {
			throw new CompteNotFoundException(
					"Compte inconnu pour cet utilisateur");
		}
		return compte;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void updateSolde(String compteId, long difference)
			throws CompteNotFoundException {
		Compte compte = getCompteById(compteId);
		compte.setSolde(compte.getSolde() + difference);
		sessionFactory.getCurrentSession().update(compte);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getAll() {
		String query = "from Compte compte order by compte.id";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
}
