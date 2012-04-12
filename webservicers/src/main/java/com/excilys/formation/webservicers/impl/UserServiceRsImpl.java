package com.excilys.formation.webservicers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.exception.CompteNotFoundException;
import com.excilys.formation.bank.service.UserService;
import com.excilys.formation.dto.CompteDTO;
import com.excilys.formation.webservicers.UserServiceRs;

/**
 * UserServiceRsImpl interface.
 * 
 * @author excilys
 * 
 */
@Service("userServiceRsImpl")
public class UserServiceRsImpl implements UserServiceRs {

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier("Compte2CompteDTOConverter")
	private Converter<Compte, CompteDTO> compte2CompteDTOConverter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<CompteDTO> getComptesByUsername(String login) {
		Set<Compte> comptes = userService.getComptesByUsername(login);
		List<CompteDTO> comptesDTO = new ArrayList<CompteDTO>();
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
