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
public class OperationComptable {

	/**
	 * OperationCategorie Enum.
	 * 
	 * @author excilys
	 * 
	 */
	public enum OperationComptableType {
		CREDIT, DEBIT
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operation_type_id")
	private Integer operationId;

	@Column(name = "operation_type")
	@Enumerated(EnumType.STRING)
	private OperationComptableType operationComptableType;

	public final Integer getOperationId() {
		return operationId;
	}

	public final OperationComptableType getOperationComptableType() {
		return operationComptableType;
	}

	public final void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	public final void setOperationComptableType(
			OperationComptableType operationComptableType) {
		this.operationComptableType = operationComptableType;
	}

}
