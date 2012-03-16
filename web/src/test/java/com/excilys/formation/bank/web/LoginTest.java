package com.excilys.formation.bank.web;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author excilys
 * 
 */
public class LoginTest extends FluentTest {

	@Page
	public LoginPage loginPage;

	@Before
	public final void before() {
		goTo(this.loginPage);
	}

	@Test
	public final void goodUsername() {
		this.loginPage.login("luc", "admin");
		// assertThat(pageSource()).contains("luc");

	}

	@Test
	public final void goToLogin() {
		assertThat(this.loginPage).isAt();
	}

	@Test
	public final void wrongUsername() {
		this.loginPage.login("awrongusename", "andawrongpassword");
		this.loginPage.isShowingErrors();
	}
}
