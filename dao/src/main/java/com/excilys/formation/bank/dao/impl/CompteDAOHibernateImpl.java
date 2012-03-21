package com.excilys.formation.bank.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.dao.CompteDAO;

@Repository("compteDAO")
public class CompteDAOHibernateImpl implements CompteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Compte loadCompteByUsernameAndAccountId(String login, String id) {
		return (Compte) sessionFactory.getCurrentSession()
				.get(Compte.class, id);
		// List<?> result = sessionFactory
		// .getCurrentSession()
		// .createSQLQuery(
		// "select c from comptes c, users_comptes u where c.compte_id=:compteId and c.compte_id=u.compte_id and u.login=:login")
		// .setString("compteId", id).setString("login", login).list();
		// if (result.isEmpty()) {
		// return null;
		// }
		// return (Compte) result.get(0);
	}
}
