package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;

import org.fluentlenium.core.FluentPage;

/**
 * This class uses the PageObject pattern and describes the main page of the
 * application.
 * 
 * @author excilys
 * 
 */
public class VirementPage extends FluentPage {

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
	 * Checks with assertions that the page is showing errors.
	 */
	public final void isShowingErrors() {
		assertThat(find(".error")).isNotEmpty();
	}

	/**
	 * hack the form to set the compte debiteur to the given one (this fonction
	 * is used to check that one can't steal money from an account just by
	 * knowing its id). The hacked option is the first one
	 * 
	 * @param account
	 */
	public final void hackForm(String account) {
		executeScript("document.getElementById('compteDebiteur').options[0].value='"
				+ account + "'");
	}

	public final void fillFormAndSend(int montant, String libelle) {

		fill("#montant").with("" + montant);
		fill("#libelle").with(libelle);
		click("#submit");
	}

}