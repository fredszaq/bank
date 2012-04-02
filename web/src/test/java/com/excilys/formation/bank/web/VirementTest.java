package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests on the login page.
 * 
 * 
 * @author excilys
 * 
 */
public class VirementTest extends FluentTest {

	@Page
	private LoginPage loginPage;

	@Page
	private AdminPage adminPage;

	@Page
	private AccountsPage userPage;

	@Page
	private VirementPage virementPage;

	/**
	 * Set up method, loging as robert and going to the user page
	 */
	@Before
	public final void before() {
		goTo(loginPage);
		loginPage.login("robert", "robert");
		goTo(virementPage);
	}

	/**
	 * In this test checks that we are on the right page.
	 */
	@Test
	public final void virementIsAccesible() {
		assertThat(virementPage).isAt();
	}

	@Test
	public final void tryTohackTheForm() {
		goTo(userPage);
		double solde = userPage.getAccountSolde("compte_courant_robert");
		goTo(virementPage);
		virementPage.hackForm("compte_courant_jacky");
		virementPage.fillFormAndSend(1, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde);

	}

}