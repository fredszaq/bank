package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;

import org.fluentlenium.core.FluentPage;

public class LoginPage extends FluentPage {

	@Override
	public String getUrl() {
		return TestConstants.BASE_URL + "login.html";
	}

	@Override
	public void isAt() {
		assertThat(find("#j_username")).hasSize(1);
		assertThat(find("#j_password")).hasSize(1);
		assertThat(find("#_spring_security_remember_me")).hasSize(1);
	}
}
