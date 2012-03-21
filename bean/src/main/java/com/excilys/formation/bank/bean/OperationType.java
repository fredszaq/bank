package com.excilys.formation.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operation_types")
public class OperationType {

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

	public Integer getOperationId() {
		return this.operationId;
	}

	public OperationCategorie getOperationType() {
		return this.operationType;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	public void setOperationType(OperationCategorie operationType) {
		this.operationType = operationType;
	}

}
