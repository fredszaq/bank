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
 * Bean OperationType.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "operation_types")
public class OperationType {

	/**
	 * OperationCategorie Enum.
	 * 
	 * @author excilys
	 * 
	 */
	public enum OperationCategorie {
		CREDIT, DEBIT
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operation_type_id")
	private Integer operationId;

	@Column(name = "operation_type")
	@Enumerated(EnumType.STRING)
	private OperationCategorie operationType;

	public final Integer getOperationId() {
		return operationId;
	}

	public final OperationCategorie getOperationType() {
		return operationType;
	}

	public final void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	public final void setOperationType(OperationCategorie operationType) {
		this.operationType = operationType;
	}

}
