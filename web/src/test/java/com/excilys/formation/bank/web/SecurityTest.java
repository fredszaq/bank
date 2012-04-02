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
public class SecurityTest extends FluentTest {

	@Page
	private LoginPage loginPage;

	@Page
	private AdminPage adminPage;

	@Page
	private AccountsPage userPage;

	@Override
	public WebDriver getDefaultDriver() {
		return new HtmlUnitDriver();
	}

	/**
	 * Set up method, going to the login page.
	 */
	@Before
	public final void before() {
		goTo(loginPage);
	}

	/**
	 * In this test checks that we are on the right page.
	 */
	@Test
	public final void loginIsAccesible() {
		assertThat(loginPage).isAt();
	}

	/**
	 * In this test a good username and password are used and it is checked that
	 * in the next page the username is displayed.
	 */
	@Test
	public final void tryToLoginWithAGoodUsername() {
		loginPage.login("luc", "admin");
		assertThat($("#logininfo").first().getText()).contains("Luc Mazon");

	}

	/**
	 * In this test a wrong username and password are used and it is checked
	 * that the next page contains errors.
	 */
	@Test
	public final void tryToLoginWithAWrongUsername() {
		loginPage.login("awrongusename", "andawrongpassword");
		loginPage.isShowingErrors();
	}

	/**
	 * this test tries to access an admin page after having logged as an admin.
	 */
	@Test
	public final void tryToViewAnAdminPageAsAnAdmin() {
		loginPage.login("fredszaq", "admin");
		assertThat(adminPage).isAt();
	}

	/**
	 * this test tries to access an admin page after having logged as a normal
	 * user.
	 */
	@Test
	public final void tryToViewAnAdminPageAsANormalUser() {
		loginPage.login("robert", "robert");
		goTo(adminPage);
		assertThat(pageSource()).contains("403");
	}

	/**
	 * this test tries to access an admin page without having logged.
	 */
	@Test
	public final void tryToViewAnAdminPageWithoutBeingLogged() {
		goTo(adminPage);
		assertThat(loginPage).isAt();
	}

	/**
	 * this test tries to access a secured page after having logged as an admin.
	 */
	@Test
	public final void tryToViewASecuredPageAnAdmin() {
		loginPage.login("stan", "admin");
		goTo(userPage);
		assertThat(userPage).isAt();
	}

	/**
	 * this test tries to access a secured page after having logged as a normal
	 * user.
	 */
	@Test
	public final void tryToViewASecuredPageAsANormalUser() {
		loginPage.login("jacky", "jacky");
		assertThat(userPage).isAt();
	}

	/**
	 * this test tries to access a secured page without having logged.
	 */
	@Test
	public final void tryToViewASecuredPageWithoutBeingLogged() {
		goTo(userPage);
		assertThat(loginPage).isAt();
	}

}
