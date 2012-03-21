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
	private AccountsPage userPage;

	/**
	 * Set up method, going to the login page.
	 */
	@Before
	public final void before() {
		goTo(this.loginPage);
	}

	/**
	 * In this test checks that we are on the right page.
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
		assertThat($("#logininfo").first().getText()).contains("Luc Mazon");

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

	/**
	 * this test tries to access an admin page after having logged as an admin.
	 */
	@Test
	public final void tryToViewAnAdminPageAsAnAdmin() {
		this.loginPage.login("fredszaq", "admin");
		assertThat(this.adminPage).isAt();
	}

	/**
	 * this test tries to access an admin page after having logged as a normal
	 * user.
	 */
	@Test
	public final void tryToViewAnAdminPageAsANormalUser() {
		this.loginPage.login("robert", "robert");
		goTo(this.adminPage);
		assertThat(pageSource()).contains("403");
	}

	/**
	 * this test tries to access an admin page without having logged.
	 */
	@Test
	public final void tryToViewAnAdminPageWithoutBeingLogged() {
		goTo(this.adminPage);
		assertThat(this.loginPage).isAt();
	}

	/**
	 * this test tries to access a secured page after having logged as an admin.
	 */
	@Test
	public final void tryToViewASecuredPageAnAdmin() {
		this.loginPage.login("stan", "admin");
		goTo(this.userPage);
		assertThat(this.userPage).isAt();
	}

	/**
	 * this test tries to access a secured page after having logged as a normal
	 * user.
	 */
	@Test
	public final void tryToViewASecuredPageAsANormalUser() {
		this.loginPage.login("jacky", "jacky");
		assertThat(this.userPage).isAt();
	}

	/**
	 * this test tries to access a secured page without having logged.
	 */
	@Test
	public final void tryToViewASecuredPageWithoutBeingLogged() {
		goTo(this.userPage);
		assertThat(this.loginPage).isAt();
	}

}
