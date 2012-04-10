package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;

/**
 * This class uses the PageObject pattern and describes the main page of the
 * application.
 * 
 * @author excilys
 * 
 */
public class VirementPage extends BankRootPage {

	@Override
	public final String getUrl() {
		return TestConstants.BASE_URL + "secure/virement.html";
	}

	@Override
	public final void isAt() {
		assertThat(find("#compteDebiteur")).hasSize(1);
		assertThat(find("#compteCrediteur")).hasSize(1);
		assertThat(find("#montant")).hasSize(1);
		assertThat(find("#libelle")).hasSize(1);
	}

	/**
	 * hack the form to set the compte debiteur to the given one (this fonction
	 * is used to check that one can't steal money from an account just by
	 * knowing its id). The hacked option is the first one
	 * 
	 * @param account
	 *            the account id to be debited
	 */
	public final void hackForm(String account) {
		executeScript("document.getElementById('compteDebiteur').options[0].value='"
				+ account + "'");
	}

	/**
	 * Fills the form with the given values.
	 * 
	 * @param montant
	 *            the montant of the virement
	 * @param libelle
	 *            the libelle
	 */
	public final void fillFormAndSend(String compteDebiteur,
			String compteCrediteur, double montant, String libelle) {
		findFirst("#compteDebiteur option[value=" + compteDebiteur + "]")
				.click();
		findFirst("#compteCrediteur option[value=" + compteCrediteur + "]")
				.click();
		fill("#montant").with("" + montant);
		fill("#libelle").with(libelle);
		click("#submit");
	}

}
