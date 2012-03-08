package com.excilys.formation.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Entity;

@Entity
@Table(name="SOME_ENTITY", uniqueConstraints = {@UniqueConstraint(columnNames={"SOME_STRING"})})
public class SomeEntity {

	@Id
	@Column(name = "SOME_STRING")
	private String someString;
	@Column(name="SOME_INT")
	private int someInteger;
	@Column(name="SOME_DATE")
	private Date someDate;

	public String getSomeString() {
		return someString;
	}
	public final void setSomeString(String someString) {
		this.someString = someString;
	}
	public final int getSomeInteger() {
		return someInteger;
	}
	public final void setSomeInteger(int someInteger) {
		this.someInteger = someInteger;
	}
	public Date getSomeDate() {
		return someDate;
	}
	public void setSomeDate(Date someDate) {
		this.someDate = someDate;
	}
	@Override
	public String toString() {
		return "SomeEntity [someString=" + someString + ", someInteger="
				+ someInteger + ", someDate=" + someDate + "]";
	}
	
	
	
}
