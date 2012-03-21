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
		// TODO prendre en compte le login !
		return (Compte) sessionFactory.getCurrentSession()
				.get(Compte.class, id);

		// String query =
		// "select user.comptes from User user where user.comptes.compteId = ? and user.login= ?";
		// return (Compte) sessionFactory.getCurrentSession().createQuery(query)
		// .setString(0, id).setString(1, login).list().get(0);
	}
}
