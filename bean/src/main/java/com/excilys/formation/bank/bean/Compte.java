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
public class Compte implements Serializable, Comparable<Compte> {

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
	@Column(name = "compte_type")
	private CompteType compteType;

	@Column
	private Double solde;

	@Id
	@Column(name = "compte_id")
	private String compteId;

	@Override
	public int compareTo(Compte compte) {
		return getCompteId().compareTo(compte.getCompteId());
	}

	public String getCompteId() {
		return this.compteId;
	}

	public CompteType getCompteType() {
		return this.compteType;
	}

	public Double getSolde() {
		return this.solde;
	}

	public void setCompteId(String compteId) {
		this.compteId = compteId;
	}

	public void setCompteType(CompteType compteType) {
		this.compteType = compteType;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

}