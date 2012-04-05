package com.excilys.formation.webservice.impl;

import java.util.HashSet;
import java.util.Set;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.service.UserService;
import com.excilys.formation.webservice.UserServiceWs;
import com.excilys.formation.webservice.dto.bean.CompteDTO;

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
	public final Set<CompteDTO> getComptesByUsername(String login) {
		Set<Compte> comptes = userService.getComptesByUsername(login);
		Set<CompteDTO> comptesDTO = new HashSet<CompteDTO>();
		for (Compte compte : comptes) {
			comptesDTO.add(new CompteDTO.CompteDTOBuilder()
					.withCompteType(compte.getCompteType())
					.withNumCarte(compte.getNumCarte())
					.withSolde(compte.getSolde())
					.withTauxInteret(compte.getTauxInteret()).build());
		}
		return comptesDTO;
	}
}
