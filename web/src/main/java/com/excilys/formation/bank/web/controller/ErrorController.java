package com.excilys.formation.bank.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A controller used for error section.
 * 
 * @author excilys
 * 
 */
@Controller
@RequestMapping("/error/*")
public class ErrorController {
	/**
	 * Returns the accessDenied page.
	 * 
	 * @return "accessDenied"
	 */
	@RequestMapping("/accessDenied.html")
	public final String accessDenied() {
		return "accessDenied";
	}

	/**
	 * Returns the accessDenied page.
	 * 
	 * @return "accessDenied"
	 */
	@RequestMapping("/403.html")
	public final String error403() {
		return "redirect:/error/accessDenied.html";
	}
}
