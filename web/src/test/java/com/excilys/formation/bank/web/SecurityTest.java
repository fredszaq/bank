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
public class SecurityTest extends FluentTest {

	@Page
	private LoginPage loginPage;

	@Page
	private AdminPage adminPage;

	@Page
	private UserPage userPage;

	/**
	 * Set up method, we go to the login page.
	 */
	@Before
	public final void before() {
		goTo(this.loginPage);
	}

	/**
	 * In this test we check that we are on the right page.
	 */
	@Test
	public final void loginIsAccesible() {
		assertThat(this.loginPage).isAt();
	}

	/**
	 * In this test a good username and password are used and it is checked that
	 * in the next page the username is displayed.
	 */
	@Test
	public final void tryToLoginWithAGoodUsername() {
		this.loginPage.login("luc", "admin");
		assertThat($("#logininfo").first().getText()).contains("luc");

	}

	/**
	 * In this test a wrong username and password are used and it is checked
	 * that the next page contains errors.
	 */
	@Test
	public final void tryToLoginWithAWrongUsername() {
		this.loginPage.login("awrongusename", "andawrongpassword");
		this.loginPage.isShowingErrors();
	}

	@Test
	public final void tryToViewAnAdminPageAsAnAdmin() {
		this.loginPage.login("fredszaq", "admin");
		goTo(this.adminPage);
		assertThat(this.adminPage).isAt();
	}

	@Test
	public final void tryToViewAnAdminPageAsANormalUser() {
		this.loginPage.login("robert", "robert");
		goTo(this.adminPage);
		assertThat(this.loginPage).isAt();
	}

	@Test
	public final void tryToViewAnAdminPageWithoutBeingLogged() {
		goTo(this.adminPage);
		assertThat(this.loginPage).isAt();
	}

	@Test
	public final void tryToViewASecuredPageWithoutBeingLogged() {
		goTo(this.userPage);
		assertThat(this.loginPage).isAt();
	}

}
