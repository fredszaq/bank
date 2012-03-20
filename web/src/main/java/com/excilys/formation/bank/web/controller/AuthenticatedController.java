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
 * A controller used for authenticated section.
 * 
 * @author excilys
 * 
 */
@Controller
@RequestMapping("/secure/*")
public class AuthenticatedController {

	@Autowired
	private UserService userService;

	/**
	 * Returns the user page.
	 * 
	 * @param model
	 *            the modelMap
	 * @return "user"
	 */
	@RequestMapping("/user.html")
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
