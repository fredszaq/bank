package com.excilys.formation.bank.dao.impl;

import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.UserDAO;

/**
 * Hibernate implementation for the UserDAO interface.
 * 
 * @author excilys
 * 
 */
@Repository("userDAO")
public class UserDAOHibernateImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final User loadUserByUsername(String login) {
		return (User) sessionFactory.getCurrentSession().get(User.class, login);
	}

	@Override
	public void updatelastConnectionDate(String login) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class,
				login);
		user.setLastConnection(new DateTime());
		sessionFactory.getCurrentSession().save(user);
	}
}
