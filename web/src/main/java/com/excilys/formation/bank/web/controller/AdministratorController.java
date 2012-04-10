package com.excilys.formation.bank.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.service.UserService;

/**
 * A controller used for administrator section.
 * 
 * @author excilys
 * 
 */
@Controller
@RequestMapping("/secure/admin/*")
public class AdministratorController {

	@Autowired
	private UserService userService;

	/**
	 * Returns the user page.
	 * 
	 * @return "admin"
	 */
	@RequestMapping("/admin.html")
	public final String admin(ModelMap model) {
		Set<Compte> comptes = userService.getComptesByUsername("robert");
		Set<Compte> comptes_jacky = userService.getComptesByUsername("jacky");
		comptes.addAll(comptes_jacky);
		model.put("comptes", comptes);
		return "admin";
	}

	private String concatenerUsers(Set<User> users, String separator) {
		StringBuilder result = new StringBuilder();
		for (User user : users) {
			result.append(user.getLogin());
			result.append(separator);
		}
		return result.substring(0, result.length() - 1);
	}
}
