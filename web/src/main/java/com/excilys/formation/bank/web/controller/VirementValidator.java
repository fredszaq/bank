package com.excilys.formation.bank.web.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class VirementValidator {

	@NotEmpty
	private String compteDebiteur;

	@NotEmpty
	private String compteCrediteur;

	@NotNull
	@NumberFormat(style = Style.NUMBER)
	@Min(0)
	private double montant;

	private String libelle;

	public String getCompteDebiteur() {
		return compteDebiteur;
	}

	public void setCompteDebiteur(String compteDebiteur) {
		this.compteDebiteur = StringUtils.trimToNull(compteDebiteur);
	}

	public String getCompteCrediteur() {
		return compteCrediteur;
	}

	public void setCompteCrediteur(String compteCrediteur) {
		this.compteCrediteur = StringUtils.trimToNull(compteCrediteur);
	}

	public double getMontant() {
		return montant;
	}

	public long getLongMontant() {
		return (long) montant * 100;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = StringUtils.trimToNull(libelle);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VirementValidator [compteDebiteur=")
				.append(compteDebiteur).append(", compteCrediteur=")
				.append(compteCrediteur).append(", montant=").append(montant)
				.append(", libelle=").append(libelle).append("]");
		return builder.toString();
	}

}
