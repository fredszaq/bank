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
 * Bean Etat.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "etats")
public enum Etat {
	VALIDATED("VALIDATED"), WAITING("WAITING");

	@Id
	@Generated("assigned")
	@Column
	private final String etat;

	private static final Map<String, Etat> idMap = new HashMap<String, Etat>();

	static {
		for (Etat etat : EnumSet.allOf(Etat.class)) {
			idMap.put(etat.getEtat(), etat);
		}
	}

	private Etat(final String etat) {
		this.etat = etat;
	}

	public String getEtat() {
		return etat;
	}

	public static Etat valueByString(String etat) {
		return idMap.get(etat);
	}

}
