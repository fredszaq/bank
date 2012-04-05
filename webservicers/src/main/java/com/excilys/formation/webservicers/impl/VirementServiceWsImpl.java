package com.excilys.formation.webservicers.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.service.VirementService;
import com.excilys.formation.webservicers.VirementServiceWs;
import com.excilys.formation.webservicers.dto.bean.TransactionDTO;

/**
 * Interface VirementService.
 * 
 * @author excilys
 * 
 */
@Path("/UserService/")
@Produces("application/json")
public class VirementServiceWsImpl implements VirementServiceWs {

	@Autowired
	private VirementService virementService;

	/**
	 * {@inheritDoc}
	 */
	@GET
	@Path("/effectuerVirement/{login}/{compteDebiteurId}/{compteCrediteurId}/{montant}/{libelle}")
	@Override
	public final TransactionDTO createVirement(
			@PathParam("login") String login,
			@PathParam("compteDebiteurId") String compteDebiteurId,
			@PathParam("compteCrediteurId") String compteCrediteurId,
			@PathParam("montant") long montant,
			@PathParam("libelle") String libelle) {
		Transaction transaction = virementService.createVirement(login,
				compteDebiteurId, compteCrediteurId, montant, libelle);
		TransactionDTO transactionDTO = new TransactionDTO.TransactionDTOBuilder()
				.withDateInit(transaction.getDateInit())
				.withDateValid(transaction.getDateValid())
				.withEtat(transaction.getEtat())
				.withLibelle(transaction.getLibelle())
				.withTransactionCategorie(transaction.getTransactionCategorie())
				.build();
		return transactionDTO;
	}
}
