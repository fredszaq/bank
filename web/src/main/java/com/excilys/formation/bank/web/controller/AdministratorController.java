package com.excilys.formation.bank.web.controller;

import java.util.List;

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

	@RequestMapping("/comptes.html")
	public final String adminComptes(ModelMap model) {
		List<Compte> comptes = userService.getAllComptes();
		model.put("comptes", comptes);
		return "adminComptes";
	}

	@RequestMapping("/users.html")
	public final String adminUsers(ModelMap model) {
		List<User> users = userService.getAllUsers();
		model.put("users", users);
		return "adminUsers";
	}

	@RequestMapping("/admin.html")
	public final String admin(ModelMap model) {
		return "adminArea";
	}

}
