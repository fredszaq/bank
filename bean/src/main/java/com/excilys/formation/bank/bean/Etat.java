package com.excilys.formation.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bean Etat.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "etats")
public class Etat {
	/**
	 * Enum de l'état de la transaction.
	 * 
	 * @author excilys
	 * 
	 */
	public enum EtatType {
		VALIDATED, WAITING;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etat_id")
	private Integer etatId;

	@Column
	@Enumerated(EnumType.STRING)
	private EtatType etat;

	public final EtatType getEtat() {
		return etat;
	}

	public final Integer getEtatId() {
		return etatId;
	}

	public final void setEtat(EtatType etat) {
		this.etat = etat;
	}

	public final void setEtatId(Integer etatId) {
		this.etatId = etatId;
	}

	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Etat [etatId=").append(etatId).append(", etat=")
				.append(etat).append("]");
		return builder.toString();
	}

}
