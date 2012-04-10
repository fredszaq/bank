package com.excilys.formation.bank.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.UserDAO;
import com.excilys.formation.bank.exception.UserNotFoundException;

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
	public final User loadUserByUsername(String login)
			throws UserNotFoundException {
		User user = (User) sessionFactory.getCurrentSession().get(User.class,
				login);
		if (user == null) {
			throw new UserNotFoundException("Utilisateur inconnu");
		}
		return user;
	}

	@Override
	public void updatelastConnectionDate(String login) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class,
				login);
		user.setLastConnection(new DateTime());
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		String query = "from User user order by user.id";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
}
