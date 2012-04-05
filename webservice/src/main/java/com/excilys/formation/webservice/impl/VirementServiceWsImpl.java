package com.excilys.formation.webservice.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.service.VirementService;
import com.excilys.formation.webservice.VirementServiceWs;

/**
 * Interface VirementService.
 * 
 * @author excilys
 * 
 */
@WebService(endpointInterface = "com.excilys.formation.webservice.VirementServiceWs")
public class VirementServiceWsImpl implements VirementServiceWs {

	@Autowired
	private VirementService virementService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Transaction createVirement(String login,
			String compteDebiteurId, String compteCrediteurId, long montant,
			String libelle) {
		return virementService.createVirement(login, compteDebiteurId,
				compteCrediteurId, montant, libelle);
	}
}
