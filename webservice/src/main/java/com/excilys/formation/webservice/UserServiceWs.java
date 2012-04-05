package com.excilys.formation.webservice;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.User;

/**
 * UserService interface.
 * 
 * @author excilys
 * 
 */

@WebService
public interface UserServiceWs {

	/**
	 * Get the compte by username.
	 * 
	 * @param login
	 *            the login
	 * @return a set of compte
	 * @throws UsernameNotFoundException
	 */
	@WebMethod
	Set<Compte> getComptesByUsername(@WebParam(name = "login") String login);

	/**
	 * {@inheritDoc}
	 */
	@WebMethod
	User loadUserByUsername(@WebParam(name = "login") String login);

}
