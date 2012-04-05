package com.excilys.formation.webservice.impl;

import java.util.Set;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.service.UserService;
import com.excilys.formation.webservice.UserServiceWs;

/**
 * UserService interface.
 * 
 * @author excilys
 * 
 */
@WebService(endpointInterface = "com.excilys.formation.webservice.UserServiceWs")
public class UserServiceWsImpl implements UserServiceWs {

	@Autowired
	private UserService userService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Set<Compte> getComptesByUsername(String login) {
		return userService.getComptesByUsername(login);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final User loadUserByUsername(String login) {
		return loadUserByUsername(login);
	}

}
