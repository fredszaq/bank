package com.excilys.formation.bank.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.UserDAO;

@Repository("userDAO")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class UserDAOHibernateImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = (User) this.sessionFactory.getCurrentSession().get(
				User.class, username);
		if (user == null) {
			throw new UsernameNotFoundException(username + "not found");
		}
		return user;
	}

}
