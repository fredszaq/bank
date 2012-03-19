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
public class LoginTest extends FluentTest {

	@Page
	private LoginPage loginPage;

	/**
	 * Set up method, we go to the login page.
	 */
	@Before
	public final void before() {
		goTo(this.loginPage);
	}

	/**
	 * In this test a good username and password are used and it is checked that
	 * in the next page the username is displayed.
	 */
	@Test
	public final void goodUsername() {
		this.loginPage.login("luc", "admin");
		assertThat(pageSource()).contains("luc");

	}

	/**
	 * In this test we check that we are on the right page.
	 */
	@Test
	public final void goToLogin() {
		assertThat(this.loginPage).isAt();
	}

	/**
	 * In this test a wrong username and password are used and it is checked
	 * that the next page contains errors.
	 */
	@Test
	public final void wrongUsername() {
		this.loginPage.login("awrongusename", "andawrongpassword");
		this.loginPage.isShowingErrors();
	}
}
