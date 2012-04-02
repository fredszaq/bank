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
 * Bean OperationComptable.
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

	private static final Map<String, OperationType> idMap = new HashMap<String, OperationType>();

	static {
		for (OperationType operation : EnumSet.allOf(OperationType.class)) {
			idMap.put(operation.getOperationType(), operation);
		}
	}

	private OperationType(final String operation) {
		operationType = operation;
	}

	public String getOperationType() {
		return operationType;
	}

	public static OperationType valueByString(String operation) {
		return idMap.get(operation);
	}
}
