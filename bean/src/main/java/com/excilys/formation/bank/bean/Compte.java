package com.excilys.formation.bank.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comptes")
public class Compte implements Serializable {

	public enum CompteType {
		EPARGNE("EPARGNE"), COURANT("COURANT");

		private final String value;

		private CompteType(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	@Enumerated(EnumType.STRING)
	private CompteType compte_type;

	@Column
	private Double solde;

	@Id
	private String compte_id;

	public String getCompte_id() {
		return this.compte_id;
	}

	public CompteType getCompteType() {
		return this.compte_type;
	}

	public Double getSolde() {
		return this.solde;
	}

	public void setCompte_id(String compte_id) {
		this.compte_id = compte_id;
	}

	public void setCompteType(CompteType compte) {
		this.compte_type = compte;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

}