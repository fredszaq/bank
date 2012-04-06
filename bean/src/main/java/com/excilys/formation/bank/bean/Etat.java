package com.excilys.formation.bank.bean;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Enum Etat.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "etat")
public enum Etat {
	VALIDATED("VALIDATED"), WAITING("WAITING");

	@Id
	@Generated("assigned")
	@Column
	private final String etat;

	private static final Map<String, Etat> ID_MAP = new HashMap<String, Etat>();

	static {
		for (Etat etat : EnumSet.allOf(Etat.class)) {
			ID_MAP.put(etat.getEtat(), etat);
		}
	}

	/**
	 * Constructeur logique.
	 * 
	 * @param etat
	 *            : l'état
	 */
	private Etat(final String etat) {
		this.etat = etat;
	}

	public String getEtat() {
		return etat;
	}

	/**
	 * Retourne l'état en fonction du nom de l'état.
	 * 
	 * @param etat
	 *            : l'état
	 * @return Etat
	 */
	public static Etat valueByString(String etat) {
		return ID_MAP.get(etat);
	}

}
