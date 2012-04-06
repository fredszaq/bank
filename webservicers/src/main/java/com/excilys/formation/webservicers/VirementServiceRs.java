package com.excilys.formation.webservicers;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.excilys.formation.webservicers.dto.bean.TransactionDTO;

/**
 * Interface VirementService.
 * 
 * @author excilys
 * 
 */
@Path("/VirementService/")
@Produces("application/json")
public interface VirementServiceRs {

	/**
	 * Création d'une opértion de virement.
	 * 
	 * @param login
	 *            : le login de l'utilisateur
	 * @param compteDebiteurId
	 *            : le compte débiteur
	 * @param compteCrediteurId
	 *            : le compte créditeur
	 * @param montant
	 *            : le montant
	 * @param libelle
	 *            : le libelle
	 * @return Transaction
	 */
	@POST
	@Path("/effectuerVirement/{login}/{compteDebiteurId}/{compteCrediteurId}/{montant}/{libelle}")
	TransactionDTO createVirement(@PathParam("login") String login,
			@PathParam("compteDebiteurId") String compteDebiteurId,
			@PathParam("compteCrediteurId") String compteCrediteurId,
			@PathParam("montant") long montant,
			@PathParam("libelle") String libelle);
}
