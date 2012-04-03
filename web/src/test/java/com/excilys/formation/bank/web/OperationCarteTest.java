package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Tests on the login page.
 * 
 * 
 * @author excilys
 * 
 */
public class OperationCarteTest extends FluentTest {

	@Page
	private LoginPage loginPage;

	@Page
	private AccountsPage userPage;

	@Page
	private OperationCartePage operationCartePage;

	@Override
	public WebDriver getDefaultDriver() {
		return new HtmlUnitDriver(true);
	}

	/**
	 * Set up method, logging as robert and going to the user page.
	 */
	@Before
	public final void before() {
		goTo(loginPage);
		loginPage.login("robert", "robert");
		goTo(operationCartePage);
	}

	/**
	 * This test checks that we are on the right page.
	 */
	@Test
	public final void virementIsAccesible() {
		assertThat(operationCartePage).isAt();
	}

	@Test
	public final void tryMakeAnOperationCarte() {
		goTo(userPage);
		double solde1 = userPage.getAccountSolde("compte_courant_robert");
		goTo(operationCartePage);
		operationCartePage.fillFormAndSend("compte_courant_robert", 0.01,
				"test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde1 - 0.01);
	}

	/**
	 * This test uses some javascript to modify the html page and sets the
	 * compte debiteur to one owned by another user. We check that the virement
	 * doesn't have any effect in tht case.
	 */
	@Test
	public final void tryTohackTheForm() {
		goTo(userPage);
		double solde = userPage.getAccountSolde("compte_courant_robert");
		goTo(operationCartePage);
		operationCartePage.hackForm("compte_courant_jacky");
		operationCartePage.fillFormAndSend("compte_courant_jacky", 1, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde);

	}

}