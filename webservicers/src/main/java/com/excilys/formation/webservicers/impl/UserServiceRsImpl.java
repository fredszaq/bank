package com.excilys.formation.webservicers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.service.UserService;
import com.excilys.formation.webservicers.UserServiceRs;
import com.excilys.formation.webservicers.dto.bean.CompteDTO;

/**
 * UserService interface.
 * 
 * @author excilys
 * 
 */
@Service("userServiceRsImpl")
public class UserServiceRsImpl implements UserServiceRs {

	@Autowired
	private UserService userService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<CompteDTO> getComptesByUsername(String login) {
		Set<Compte> comptes = userService.getComptesByUsername(login);
		List<CompteDTO> comptesDTO = new ArrayList<CompteDTO>();
		for (Compte compte : comptes) {
			comptesDTO.add(new CompteDTO.CompteDTOBuilder()
					.withCompteType(compte.getCompteType())
					.withNumCarte(compte.getNumCarte())
					.withSolde(compte.getSolde())
					.withTauxInteret(compte.getTauxInteret()).build());
		}
		return comptesDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final CompteDTO getCompteByUsernameAndAccountId(String login,
			String id) {
		Compte compte = userService.getCompteByUsernameAndAccountId(login, id);
		CompteDTO compteDTO = new CompteDTO.CompteDTOBuilder()
				.withCompteType(compte.getCompteType())
				.withNumCarte(compte.getNumCarte())
				.withSolde(compte.getSolde())
				.withTauxInteret(compte.getTauxInteret()).build();
		return compteDTO;
	}

	@Override
	public String simpleMethod(String login) {
		return login;
	}
}
