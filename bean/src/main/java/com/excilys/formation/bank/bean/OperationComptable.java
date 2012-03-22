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
 * Bean OperationComptable.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "operation_types")
public class OperationComptable {

	/**
	 * OperationComptableType Enum.
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
	private Integer operationComptableId;

	@Column(name = "operation_type")
	@Enumerated(EnumType.STRING)
	private OperationComptableType operationComptableType;

	public final Integer getOperationComptableId() {
		return operationComptableId;
	}

	public final OperationComptableType getOperationComptableType() {
		return operationComptableType;
	}

	public final void setOperationComptableId(Integer operationComptableId) {
		this.operationComptableId = operationComptableId;
	}

	public final void setOperationComptableType(
			OperationComptableType operationComptableType) {
		this.operationComptableType = operationComptableType;
	}

	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OperationComptable [operationComptableId=")
				.append(operationComptableId)
				.append(", operationComptableType=")
				.append(operationComptableType).append("]");
		return builder.toString();
	}

}
