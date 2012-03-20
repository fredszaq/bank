package com.excilys.formation.bank.bean;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Compte bean.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "comptes")
public class Compte implements Serializable, Comparable<Compte> {

	/**
	 * CompteType enum.
	 * 
	 * @author excilys
	 * 
	 */
	public enum CompteType {
		EPARGNE, COURANT;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8546946063789928623L;

	@Enumerated(EnumType.STRING)
	@Column(name = "compte_type")
	private CompteType compteType;

	@Column
	private Double solde;

	@Id
	@Generated("assigned")
	@Column(name = "compte_id")
	private String compteId;

	@Override
	public final int compareTo(Compte compte) {
		return getCompteId().compareTo(compte.getCompteId());
	}

	public final String getCompteId() {
		return this.compteId;
	}

	public final CompteType getCompteType() {
		return this.compteType;
	}

	public final Double getSolde() {
		return this.solde;
	}

	public final void setCompteId(String compteId) {
		this.compteId = compteId;
	}

	public final void setCompteType(CompteType compteType) {
		this.compteType = compteType;
	}

	public final void setSolde(Double solde) {
		this.solde = solde;
	}

	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [compteType=").append(this.compteType)
				.append(", solde=").append(this.solde).append(", compteId=")
				.append(this.compteId).append("]");
		return builder.toString();
	}

}