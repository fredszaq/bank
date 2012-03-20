package com.excilys.formation.bank.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A controller used for home section.
 * 
 * @author excilys
 * 
 */
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @return "index"
	 */
	@RequestMapping("/index.html")
	public final String home() {
		return "index";
	}

	/**
	 * Returns the login page.
	 * 
	 * @return "login"
	 */
	@RequestMapping("/login.html")
	public final String login() {
		return "login";
	}

}
