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
import org.springframework.web.bind.annotation.RequestParam;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.service.UserService;
import com.excilys.formation.bank.service.VirementService;

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

	@Autowired
	private VirementService virementService;

	@RequestMapping("/account.html")
	public final String account(ModelMap model, @RequestParam String id) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Compte compte = userService.getCompteByUsernameAndAccountId(
				userDetails.getUsername(), id);
		if (compte == null) {
			return "redirect:/";
		}
		model.put("compte", compte);
		model.put("operations", userService.getOperationsNonCarteByCompteId(id));
		model.put("totalCarte",
				userService.getTotalOperationsCarteByCompteId(id));
		return "account";
	}

	/**
	 * Returns the user page.
	 * 
	 * @param model
	 *            the modelMap
	 * @return "user"
	 */
	@RequestMapping("/accounts.html")
	public final String accounts(ModelMap model) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Set<Compte> comptes = userService.getComptesByUsername(userDetails
				.getUsername());
		LinkedList<Compte> listeComptes = new LinkedList<Compte>(comptes);
		Collections.sort(listeComptes);
		model.put("comptes", listeComptes);
		return "accounts";
	}

	@RequestMapping("/virement.html")
	public final String virement(ModelMap model) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Set<Compte> comptes = userService.getComptesByUsername(userDetails
				.getUsername());
		LinkedList<Compte> listeComptes = new LinkedList<Compte>(comptes);
		Collections.sort(listeComptes);
		model.put("comptes", listeComptes);
		return "virement";
	}

	@RequestMapping("/virement.form")
	public final String doVirement(@RequestParam String compteDebiteur,
			@RequestParam String compteCrediteur, @RequestParam double montant,
			@RequestParam String libelle) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String login = userDetails.getUsername();
		Transaction transaction = virementService.createVirement(login,
				compteDebiteur, compteCrediteur, montant, libelle);
		if (transaction != null) {
			return "redirect:/secure/account.html?id=" + compteDebiteur;
		}
		return "redirect:/secure/virement.html?error=1";

	}

	@RequestMapping("/detailCarte.html")
	public final String detailsCarte(ModelMap model, @RequestParam String id) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Compte compte = userService.getCompteByUsernameAndAccountId(
				userDetails.getUsername(), id);
		if (compte == null) {
			return "redirect:/";
		}
		model.put("compte", compte);
		model.put("operations", userService.getOperationsCarteByCompteId(id));
		return "detailCarte";

	}
}
