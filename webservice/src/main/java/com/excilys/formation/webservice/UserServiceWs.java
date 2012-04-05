package com.excilys.formation.webservice;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.excilys.formation.webservice.dto.bean.CompteDTO;

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
	Set<CompteDTO> getComptesByUsername(@WebParam(name = "login") String login);

}
