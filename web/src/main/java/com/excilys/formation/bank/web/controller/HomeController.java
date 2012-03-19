package com.excilys.formation.bank.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A controller used for test purposes.
 * 
 * @author excilys
 * 
 */
@Controller
public class HomeController {

	/**
	 * Returns the user page.
	 * 
	 * @return "admin"
	 */
	@RequestMapping("/secure/admin/admin.html")
	public final String admin() {
		return "admin";
	}

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

	/**
	 * Returns the user page.
	 * 
	 * @return "user"
	 */
	@RequestMapping("/secure/user.html")
	public final String user(ModelMap model) {
		return "user";
	}

}
