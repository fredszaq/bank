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
@Table(name = "compte_types")
public enum CompteType {
	COURANT("COURANT"), EPARGNE("EPARGNE");

	@Id
	@Generated("assigned")
	@Column(name = "compte_type")
	private final String compteType;

	private static final Map<String, CompteType> idMap = new HashMap<String, CompteType>();

	static {
		for (CompteType compteType : EnumSet.allOf(CompteType.class)) {
			idMap.put(compteType.getCompteType(), compteType);
		}
	}

	private CompteType(final String compteType) {
		this.compteType = compteType;
	}

	public String getCompteType() {
		return compteType;
	}

	public static CompteType valueByString(String compteType) {
		return idMap.get(compteType);
	}

}
