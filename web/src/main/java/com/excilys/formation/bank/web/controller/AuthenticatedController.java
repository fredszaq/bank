package com.excilys.formation.bank.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.exception.CompteNotFoundException;
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

	private static Map<Integer, Date> MONTHS;

	public void constructMonths() {
		DateTime dateTime = new DateTime();
		MONTHS = new HashMap<Integer, Date>();
		MONTHS.put(0, dateTime.toDate());
		MONTHS.put(1, dateTime.minusMonths(1).toDate());
		MONTHS.put(2, dateTime.minusMonths(2).toDate());
		MONTHS.put(3, dateTime.minusMonths(3).toDate());
		MONTHS.put(4, dateTime.minusMonths(4).toDate());
		MONTHS.put(5, dateTime.minusMonths(5).toDate());
	}

	private boolean monthHasChanged() {
		DateTime dateTime = new DateTime();
		DateTime dateTime2 = new DateTime(MONTHS.get(0));
		if (dateTime2 == null
				|| (dateTime.getMonthOfYear() != dateTime2.getMonthOfYear())) {
			return true;
		}
		return false;
	}

	@RequestMapping("/account/{month}/{id}.html")
	public final String account(ModelMap model, @PathVariable String id,
			@PathVariable Integer month) {
		if (MONTHS == null || monthHasChanged()) {
			constructMonths();
		}
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Compte compte = null;
		try {
			compte = userService.getCompteByUsernameAndAccountId(
					userDetails.getUsername(), id);
		} catch (CompteNotFoundException cnfe) {
			return "redirect:/";
		}
		List<Operation> operations = userService
				.getOperationsNonCarteByCompteId(id, month);
		model.put("compte", compte);
		model.put("operations", operations);
		model.put("totalCarte",
				userService.getTotalOperationsCarteByCompteId(id, month));
		model.put("months", MONTHS);
		model.put("month", month);
		return "account";
	}

	@RequestMapping("/account/{month}/{id}.xls")
	public final String accountExcel(ModelMap model, @PathVariable String id,
			@PathVariable Integer month) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Compte compte = null;
		try {
			compte = userService.getCompteByUsernameAndAccountId(
					userDetails.getUsername(), id);
		} catch (CompteNotFoundException cnfe) {
			return "redirect:/";
		}
		List<Operation> operations = userService.getOperationsByCompteId(id,
				month);
		model.put("compte", compte);
		model.put("operations", operations);
		return "accountExcel";
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
		HashMap<String, Long> soldesPrevisionnels = new HashMap<String, Long>();
		HashMap<String, Long> encoursCartes = new HashMap<String, Long>();
		for (Compte compte : comptes) {
			// TODO s'il y a autre chose que des débits en différé, faudra gérer
			// le signe
			long totalOperationsNonValidees = userService
					.getTotalOperationsNonValideesByCompteId(compte
							.getCompteId());
			soldesPrevisionnels.put(compte.getCompteId(), compte.getSolde()
					- totalOperationsNonValidees);
			encoursCartes
					.put(compte.getCompteId(), -totalOperationsNonValidees);

		}
		model.put("comptes", comptes);
		model.put("soldesPrevisionnels", soldesPrevisionnels);
		model.put("encoursCartes", encoursCartes);
		return "accounts";
	}

	@RequestMapping("/detailCarte/{month}/{id}.html")
	public final String detailsCarte(ModelMap model, @PathVariable String id,
			@PathVariable Integer month) {
		if (MONTHS == null || monthHasChanged()) {
			constructMonths();
		}
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Compte compte = null;
		try {
			compte = userService.getCompteByUsernameAndAccountId(
					userDetails.getUsername(), id);
		} catch (CompteNotFoundException cnfe) {
			return "redirect:/";
		}
		if (!compte.hasCarte()) {
			return "redirect:/";
		}
		model.put("compte", compte);
		model.put("operations",
				userService.getOperationsCarteByCompteId(id, month));
		model.put("months", MONTHS);
		model.put("month", month);
		return "detailCarte";

	}
}
