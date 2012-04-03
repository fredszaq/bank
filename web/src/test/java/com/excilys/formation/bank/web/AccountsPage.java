package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;

/**
 * This class uses the PageObject pattern and describes the main page of the
 * application.
 * 
 * @author excilys
 * 
 */
public class AccountsPage extends BankRootPage {

	@Override
	public final String getUrl() {
		return TestConstants.BASE_URL + "secure/accounts.html";
	}

	@Override
	public final void isAt() {
		assertThat(pageSource()).contains("Only logged users can view this !");
	}

	public final long getAccountSolde(String account) {
		String solde = $("#solde_" + account).getTexts().get(0).toString();
		return Long.parseLong((solde.replaceAll("EUR| €", "").replace(",", "")
				.replace(".", "")));
	}
}
