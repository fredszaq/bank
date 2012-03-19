package com.excilys.formation.bank.service;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * A class used for test purposes.
 * 
 * TODO delete this :D
 * 
 * @author excilys
 * 
 */
// @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:context/applicationContext*.xml",
		"classpath*:contextTest/applicationContext*.xml" })
public class SimpleTest {

	@Autowired
	private UserService userService;

	/**
	 * A very rigorous test.
	 */
	@Test
	public final void essaiTest() {

		/*
		 * String password = null; Set<Authority> authorities = new
		 * HashSet<Authority>(); Authority authorityAdmin = new
		 * Authority(Type.ROLE_ADMIN); Authority authorityAuthenticated = new
		 * Authority( Type.ROLE_AUTHENTICATED); authorities.add(authorityAdmin);
		 * authorities.add(authorityAuthenticated); User user = new User("stan",
		 * password, "test", "test", "test", authorities);
		 * this.userService.ajouter(user);
		 */
		assertThat(true);
	}
}
