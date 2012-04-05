package com.excilys.formation.bank.web.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.service.OperationCarteService;
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

	@Autowired
	private OperationCarteService operationCarteService;

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

	@RequestMapping("/account.html")
	public final String account(ModelMap model, @RequestParam String id,
			@RequestParam Integer month) {
		if (MONTHS == null || monthHasChanged()) {
			constructMonths();
		}
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Compte compte = userService.getCompteByUsernameAndAccountId(
				userDetails.getUsername(), id);
		if (compte == null) {
			return "redirect:/";
		}
		List<Operation> operations = userService
				.getOperationsNonCarteByCompteId(id, month);
		model.put("compte", compte);
		model.put("operations", operations);
		model.put("totalCarte",
				userService.getTotalOperationsCarteByCompteId(id, month));
		model.put("months", MONTHS);
		return "account";
	}

	@RequestMapping("/account/{month}/{id}.xls")
	public final String accountExcel(ModelMap model, @PathVariable String id,
			@PathVariable Integer month) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Compte compte = userService.getCompteByUsernameAndAccountId(
				userDetails.getUsername(), id);
		if (compte == null) {
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
		LinkedList<Compte> listeComptes = new LinkedList<Compte>(comptes);
		Collections.sort(listeComptes);
		HashMap<String, Long> soldesPrevisionnels = new HashMap<String, Long>();
		HashMap<String, Long> encoursCartes = new HashMap<String, Long>();
		for (Compte compte : listeComptes) {
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
		model.put("comptes", listeComptes);
		model.put("soldesPrevisionnels", soldesPrevisionnels);
		model.put("encoursCartes", encoursCartes);
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
		try {
			virementService.createVirement(login, compteDebiteur,
					compteCrediteur, (long) (montant * 100),
					StringUtils.trimToNull(libelle));
		} catch (Exception e) {
			return "redirect:/secure/virement.html?error=1";
		}

		return "redirect:/secure/account.html?id=" + compteDebiteur
				+ "&month=0";

	}

	@RequestMapping("/operationCarte.html")
	public final String operationCarte(ModelMap model) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Set<Compte> comptes = userService.getComptesByUsername(userDetails
				.getUsername());
		LinkedList<Compte> listeComptes = new LinkedList<Compte>(comptes);
		LinkedList<Compte> listeComptesCartes = new LinkedList<Compte>();
		for (Compte compte : listeComptes) {
			if (compte.hasCarte()) {
				listeComptesCartes.add(compte);
			}
		}
		Collections.sort(listeComptesCartes);
		model.put("comptes", listeComptesCartes);
		return "operationCarte";
	}

	@RequestMapping("/operationCarte.form")
	public final String doOperationCarte(@RequestParam String compteDebiteur,
			@RequestParam double montant, @RequestParam String libelle) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String login = userDetails.getUsername();
		try {
			operationCarteService.createOperationCarte(login, compteDebiteur,
					(long) (montant * 100), StringUtils.trimToNull(libelle));
		} catch (Exception e) {
			return "redirect:/secure/operationCarte.html?error=1";
		}
		return "redirect:/secure/detailCarte.html?id=" + compteDebiteur
				+ "&month=0";

	}

	@RequestMapping("/detailCarte.html")
	public final String detailsCarte(ModelMap model, @RequestParam String id,
			@RequestParam Integer month) {
		if (MONTHS == null || monthHasChanged()) {
			constructMonths();
		}
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Compte compte = userService.getCompteByUsernameAndAccountId(
				userDetails.getUsername(), id);
		if (compte == null || !compte.hasCarte()) {
			return "redirect:/";
		}
		model.put("compte", compte);
		model.put("operations",
				userService.getOperationsCarteByCompteId(id, month));
		model.put("months", MONTHS);
		return "detailCarte";

	}
}
