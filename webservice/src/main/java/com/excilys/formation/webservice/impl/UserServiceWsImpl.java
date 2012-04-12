package com.excilys.formation.webservice.impl;

import java.util.HashSet;
import java.util.Set;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.exception.CompteNotFoundException;
import com.excilys.formation.bank.service.UserService;
import com.excilys.formation.dto.CompteDTO;
import com.excilys.formation.webservice.UserServiceWs;

/**
 * UserServiceWsImpl interface.
 * 
 * @author excilys
 * 
 */
@WebService(endpointInterface = "com.excilys.formation.webservice.UserServiceWs")
public class UserServiceWsImpl implements UserServiceWs {

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier("Compte2CompteDTOConverter")
	private Converter<Compte, CompteDTO> compte2CompteDTOConverter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Set<CompteDTO> getComptesByUsername(String login) {
		Set<Compte> comptes = userService.getComptesByUsername(login);
		Set<CompteDTO> comptesDTO = new HashSet<CompteDTO>();
		for (Compte compte : comptes) {
			comptesDTO.add(compte2CompteDTOConverter.convert(compte));
		}
		return comptesDTO;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws CompteNotFoundException
	 */
	@Override
	public final CompteDTO getCompteByUsernameAndAccountId(String login,
			String id) {
		Compte compte;
		try {
			compte = userService.getCompteByUsernameAndAccountId(login, id);
		} catch (CompteNotFoundException e) {
			return null;
		}
		return compte2CompteDTOConverter.convert(compte);
	}
}
