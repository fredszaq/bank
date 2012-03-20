package com.excilys.formation.bank.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A controller used for administrator section.
 * 
 * @author excilys
 * 
 */
@Controller
public class AdministratorController {
	/**
	 * Returns the user page.
	 * 
	 * @return "admin"
	 */
	@RequestMapping("/secure/admin/admin.html")
	public final String admin() {
		return "admin";
	}
}
