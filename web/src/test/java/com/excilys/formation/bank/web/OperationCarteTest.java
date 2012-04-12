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
		loginPage.login("jacky", "jacky");
		goTo(operationCartePage);
	}

	/**
	 * This test checks that we are on the right page.
	 */
	@Test
	public final void operationCarteIsAccessible() {
		assertThat(operationCartePage).isAt();
	}

	@Test
	public final void tryMakeAnOperationCarte() {
		goTo(userPage);
		long solde1 = userPage.getAccountSolde("compte_courant_jacky");
		goTo(operationCartePage);
		operationCartePage
				.fillFormAndSend("compte_courant_jacky", 0.01, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_jacky")).isEqualTo(
				solde1 - 1);
	}

	@Test
	public final void tryTohackTheForm() {

		// get le solde du compte
		goTo(userPage);
		long solde = userPage.getAccountSolde("compte_courant_jacky");

		// se deco
		click($("#logininfo a"));

		// se co en temps que robert
		goTo(loginPage);
		loginPage.login("robert", "robert");

		// hacker le truc
		goTo(operationCartePage);
		operationCartePage.hackForm("compte_courant_jacky");
		operationCartePage.fillFormAndSend("compte_courant_jacky", 1, "test");

		// se deco
		loginPage.disconnect();

		// se co en temps que jacky
		goTo(loginPage);
		loginPage.login("jacky", "jacky");

		// get le solde du compte
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_jacky")).isEqualTo(
				solde);
	}
}
