package com.excilys.formation.webservicers.impl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.service.UserService;
import com.excilys.formation.webservicers.UserServiceWs;
import com.excilys.formation.webservicers.dto.bean.CompteDTO;

/**
 * UserService interface.
 * 
 * @author excilys
 * 
 */
@Path("/UserService/")
@Produces("application/json")
public class UserServiceWsImpl implements UserServiceWs {

	@Autowired
	private UserService userService;

	/**
	 * {@inheritDoc}
	 */
	@GET
	@Path("/myaccounts/{login}")
	@Override
	public final Set<CompteDTO> getComptesByUsername(
			@PathParam("login") String login) {
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

	/**
	 * {@inheritDoc}
	 */
	@GET
	@Path("/myaccount/{login}/{id}/")
	@Override
	public final CompteDTO getCompteByUsernameAndAccountId(
			@PathParam("login") String login, @PathParam("id") String id) {
		Compte compte = userService.getCompteByUsernameAndAccountId(login, id);
		CompteDTO compteDTO = new CompteDTO.CompteDTOBuilder()
				.withCompteType(compte.getCompteType())
				.withNumCarte(compte.getNumCarte())
				.withSolde(compte.getSolde())
				.withTauxInteret(compte.getTauxInteret()).build();
		return compteDTO;
	}
}
