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
 * Enum OperationType.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "operation_types")
public enum OperationType {
	CREDIT("CREDIT"), DEBIT("DEBIT");

	@Id
	@Generated("assigned")
	@Column(name = "operation_type")
	private final String operationType;

	private static final Map<String, OperationType> ID_MAP = new HashMap<String, OperationType>();

	static {
		for (OperationType operation : EnumSet.allOf(OperationType.class)) {
			ID_MAP.put(operation.getOperationType(), operation);
		}
	}

	/**
	 * Constructeur logique.
	 * 
	 * @param operation
	 *            : l'opération
	 */
	private OperationType(final String operation) {
		operationType = operation;
	}

	public String getOperationType() {
		return operationType;
	}

	/**
	 * Retourne l'OperationType en fonction de son nom.
	 * 
	 * @param operation
	 *            : l'opération
	 * @return Operation Type
	 */
	public static OperationType valueByString(String operation) {
		return ID_MAP.get(operation);
	}
}
