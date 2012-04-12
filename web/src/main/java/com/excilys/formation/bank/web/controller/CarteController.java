package com.excilys.formation.bank.web.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.service.OperationCarteService;
import com.excilys.formation.bank.service.UserService;
import com.excilys.formation.bank.web.validator.CarteValidator;

@Controller
@RequestMapping("/secure/operationCarte.html")
public class CarteController {

	@Autowired
	private UserService userService;

	@Autowired
	private OperationCarteService operationCarteService;

	@RequestMapping(method = RequestMethod.GET)
	public final String operationCarte(ModelMap model) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		Set<Compte> comptes = userService.getComptesByUsername(userDetails
				.getUsername());
		model.put("comptes", getCompteHasCarte(comptes));
		CarteValidator carteValidator = new CarteValidator();
		model.put("carteValidator", carteValidator);
		return "operationCarte";
	}

	@RequestMapping(method = RequestMethod.POST)
	public final String processCarteFormValidation(
			@Valid @ModelAttribute("carteValidator") CarteValidator carteValidator,
			BindingResult result, ModelMap model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		if (result.hasErrors()) {
			Set<Compte> comptes = userService.getComptesByUsername(userDetails
					.getUsername());
			model.put("comptes", getCompteHasCarte(comptes));
			model.put("carteValidator", carteValidator);
			return "operationCarte";
		}

		return doOperationCarte(carteValidator);
	}

	private final List<Compte> getCompteHasCarte(Set<Compte> comptes) {
		LinkedList<Compte> listeComptes = new LinkedList<Compte>(comptes);
		LinkedList<Compte> listeComptesCartes = new LinkedList<Compte>();
		for (Compte compte : listeComptes) {
			if (compte.hasCarte()) {
				listeComptesCartes.add(compte);
			}
		}
		Collections.sort(listeComptesCartes);
		return listeComptesCartes;
	}

	private final String doOperationCarte(CarteValidator carteValidator) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String login = userDetails.getUsername();
		try {
			operationCarteService.createOperationCarte(login,
					carteValidator.getCompteDebiteur(),
					(long) (carteValidator.getMontant() * 100),
					StringUtils.trimToNull(carteValidator.getLibelle()));
		} catch (Exception e) {
			return "redirect:/secure/operationCarte.html?error=1";
		}
		StringBuilder stringBuilder = new StringBuilder(
				"redirect:/secure/detailCarte/0/");
		stringBuilder.append(carteValidator.getCompteDebiteur());
		stringBuilder.append(".html");
		return stringBuilder.toString();

	}

}
