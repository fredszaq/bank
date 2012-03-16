package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;

import com.excilys.formation.bank.web.controller.HomeController;

/**
 * 
 * @author excilys
 * 
 */
public class LoginTest extends FluentTest {
	/**
	 * A very rigorous test.
	 */
	@Test
	public final void goToLogin() {

		assertThat(new HomeController().home()).isEqualTo("index");
	}
}
