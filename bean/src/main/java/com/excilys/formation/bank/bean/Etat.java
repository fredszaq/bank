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

	@Column(name = "etat")
	@Enumerated(EnumType.STRING)
	private EtatType etatType;

	public final Integer getEtatId() {
		return etatId;
	}

	public final EtatType getEtatType() {
		return etatType;
	}

	public final void setEtatType(EtatType etatType) {
		this.etatType = etatType;
	}

	public final void setEtatId(Integer etatId) {
		this.etatId = etatId;
	}

	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Etat [etatId=").append(etatId).append(", etatType=")
				.append(etatType).append("]");
		return builder.toString();
	}

}
