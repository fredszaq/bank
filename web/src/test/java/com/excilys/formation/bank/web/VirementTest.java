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
public class VirementTest extends FluentTest {

	@Page
	private LoginPage loginPage;

	@Page
	private AccountsPage userPage;

	@Page
	private VirementPage virementPage;

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
		goTo(virementPage);
	}

	/**
	 * This test checks that we are on the right page.
	 */
	@Test
	public final void virementIsAccesible() {
		assertThat(virementPage).isAt();
	}

	/**
	 * This test tries to make a virement between twice the same compte and
	 * checks that an error is displayed.
	 */
	@Test
	public final void tryToMakeAVirementBetweenTwiceTheSameCompte() {
		virementPage.fillFormAndSend(1, "test");
		virementPage.isShowingErrors();
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
		goTo(virementPage);
		virementPage.hackForm("compte_courant_jacky");
		virementPage.fillFormAndSend(1, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde);

	}

}