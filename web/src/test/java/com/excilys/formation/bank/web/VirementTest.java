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
	private VirementInternePage virementInternePage;

	@Page
	private VirementExternePage virementExternePage;

	@Override
	public final WebDriver getDefaultDriver() {
		return new HtmlUnitDriver(true);
	}

	/**
	 * Set up method, logging as robert and going to the user page.
	 */
	@Before
	public final void before() {
		goTo(loginPage);
		loginPage.login("robert", "robert");
		goTo(virementInternePage);
	}

	/**
	 * This test checks that we are on the right page.
	 */
	@Test
	public final void virementIsAccessible() {
		assertThat(virementInternePage).isAt();
	}

	/**
	 * Just a simple virement test.
	 */
	@Test
	public final void tryMakeAVirement() {
		goTo(userPage);
		long solde1 = userPage.getAccountSolde("compte_courant_robert");
		long solde2 = userPage.getAccountSolde("compte_epargne_robert");
		goTo(virementInternePage);
		virementInternePage.fillFormAndSend("compte_courant_robert",
				"compte_epargne_robert", 1, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde1 - 100);
		assertThat(userPage.getAccountSolde("compte_epargne_robert"))
				.isEqualTo(solde2 + 100);
		// Do the virement in the other way so that we can always launch the
		// tests without going to a negative solde
		goTo(virementInternePage);
		virementInternePage.fillFormAndSend("compte_epargne_robert",
				"compte_courant_robert", 1, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde1);
		assertThat(userPage.getAccountSolde("compte_epargne_robert"))
				.isEqualTo(solde2);

	}

	/**
	 * Just a simple virement test.
	 */
	@Test
	public final void tryMakeAVirementWithCents() {
		goTo(userPage);
		long solde1 = userPage.getAccountSolde("compte_courant_robert");
		long solde2 = userPage.getAccountSolde("compte_epargne_robert");
		goTo(virementInternePage);
		virementInternePage.fillFormAndSend("compte_courant_robert",
				"compte_epargne_robert", 1.42, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde1 - 142);
		assertThat(userPage.getAccountSolde("compte_epargne_robert"))
				.isEqualTo(solde2 + 142);
		// Do the virement in the other way so that we can always launch the
		// tests without going to a negative solde
		goTo(virementInternePage);
		virementInternePage.fillFormAndSend("compte_epargne_robert",
				"compte_courant_robert", 1.42, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde1);
		assertThat(userPage.getAccountSolde("compte_epargne_robert"))
				.isEqualTo(solde2);

	}

	/**
	 * This test tries to make a virement between twice the same compte and
	 * checks that an error is displayed.
	 */
	@Test
	public final void tryToMakeAVirementBetweenTwiceTheSameCompte() {
		virementInternePage.fillFormAndSend("compte_courant_robert",
				"compte_courant_robert", 1, "test");
		virementInternePage.isShowingErrors();
	}

	/**
	 * This test uses some javascript to modify the html page and sets the
	 * compte debiteur to one owned by another user. We check that the virement
	 * doesn't have any effect in that case.
	 */
	@Test
	public final void tryTohackTheForm() {
		goTo(userPage);
		long solde = userPage.getAccountSolde("compte_courant_robert");
		goTo(virementInternePage);
		virementInternePage.hackForm("compte_courant_jacky");
		virementInternePage.fillFormAndSend("compte_courant_jacky",
				"compte_courant_robert", 1, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde);

	}

	/**
	 * Just a simple virement test.
	 */
	@Test
	public final void tryMakeAVirementExterne() {
		goTo(userPage);
		long solde1 = userPage.getAccountSolde("compte_courant_robert");

		// se déco
		userPage.disconnect();
		// se co en temps que jacky
		goTo(loginPage);
		loginPage.login("jacky", "jacky");
		goTo(userPage);
		long solde2 = userPage.getAccountSolde("compte_courant_jacky");

		// se déco
		userPage.disconnect();
		// se co en temps que robert
		goTo(loginPage);
		loginPage.login("robert", "robert");
		goTo(userPage);

		goTo(virementExternePage);
		virementExternePage.fillFormAndSend("compte_courant_robert",
				"compte_courant_jacky", 1, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde1 - 100);

		// Do the virement in the other way so that we can always launch the
		// tests without going to a negative solde
		// se déco
		userPage.disconnect();
		// se co en temps que jacky
		goTo(loginPage);
		loginPage.login("jacky", "jacky");
		goTo(userPage);

		goTo(virementExternePage);
		virementExternePage.fillFormAndSend("compte_courant_jacky",
				"compte_courant_robert", 1, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_jacky")).isEqualTo(
				solde2);
	}

	/**
	 * This test uses some javascript to modify the html page and sets the
	 * compte debiteur to one owned by another user. We check that the virement
	 * doesn't have any effect in that case.
	 */
	@Test
	public final void tryTohackTheFormExterne() {
		goTo(userPage);
		long solde = userPage.getAccountSolde("compte_courant_robert");
		goTo(virementExternePage);
		virementExternePage.hackForm("compte_courant_jacky");
		virementExternePage.fillFormAndSend("compte_courant_jacky",
				"compte_courant_robert", 1, "test");
		goTo(userPage);
		assertThat(userPage.getAccountSolde("compte_courant_robert"))
				.isEqualTo(solde);

	}

}
