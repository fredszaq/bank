package com.excilys.formation.bank.web.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.service.UserService;

/**
 * A controller used for test purposes.
 * 
 * @author excilys
 * 
 */
@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	/**
	 * Returns the accessDenied page.
	 * 
	 * @return "accessDenied"
	 */
	@RequestMapping("/error/accessDenied.html")
	public final String accessDenied() {
		return "accessDenied";
	}

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
	 * Returns the accessDenied page.
	 * 
	 * @return "accessDenied"
	 */
	@RequestMapping("/error/403.html")
	public final String error403() {
		return "redirect:/error/accessDenied.html";
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
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Set<Compte> comptes = this.userService.getComptesByUsername(userDetails
				.getUsername());
		LinkedList<Compte> listeComptes = new LinkedList<Compte>(comptes);
		Collections.sort(listeComptes);
		model.put("comptes", listeComptes);
		return "user";
	}
}
