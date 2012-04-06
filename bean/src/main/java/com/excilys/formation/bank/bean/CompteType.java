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
 * Enum CompteType.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "compte_type")
public enum CompteType {
	COURANT("COURANT"), EPARGNE("EPARGNE");

	@Id
	@Generated("assigned")
	@Column(name = "compte_type")
	private final String compteType;

	private static final Map<String, CompteType> ID_MAP = new HashMap<String, CompteType>();

	static {
		for (CompteType compteType : EnumSet.allOf(CompteType.class)) {
			ID_MAP.put(compteType.getCompteType(), compteType);
		}
	}

	/**
	 * Constructeur logique.
	 * 
	 * @param compteType
	 *            : le type du compte
	 */
	private CompteType(final String compteType) {
		this.compteType = compteType;
	}

	public final String getCompteType() {
		return compteType;
	}

	/**
	 * Retourne le CompteType en fonction de son nom.
	 * 
	 * @param compteType
	 *            : le compteType
	 * @return CompteType
	 */
	public static CompteType valueByString(String compteType) {
		return ID_MAP.get(compteType);
	}

}
