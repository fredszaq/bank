package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;

/**
 * This class uses the PageObject pattern and describes the login page of the
 * application.
 * 
 * @author excilys
 * 
 */
public class LoginPage extends BankRootPage {

	@Override
	public final String getUrl() {
		return TestConstants.BASE_URL + "login.html";
	}

	@Override
	public final void isAt() {
		assertThat(find("#j_username")).hasSize(1);
		assertThat(find("#j_password")).hasSize(1);
	}

	/**
	 * Fills the login form with the given username and password and submits it.
	 * 
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 */
	public final void login(String username, String password) {
		fill("#j_username").with(username);
		fill("#j_password").with(password);
		click("#submit");

	}
}
