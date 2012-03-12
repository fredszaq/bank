package com.excilys.formation.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "SOME_ENTITY", uniqueConstraints = { @UniqueConstraint(columnNames = { "SOME_STRING" }) })
public class SomeEntity {

	@Id
	@Column(name = "SOME_STRING")
	private String someString;
	@Column(name = "SOME_INT")
	private int someInteger;
	@Column(name = "SOME_DATE")
	private Date someDate;

	public Date getSomeDate() {
		return this.someDate;
	}

	public int getSomeInteger() {
		return this.someInteger;
	}

	public String getSomeString() {
		return this.someString;
	}

	public void setSomeDate(Date someDate) {
		this.someDate = someDate;
	}

	public void setSomeInteger(int someInteger) {
		this.someInteger = someInteger;
	}

	public void setSomeString(String someString) {
		this.someString = someString;
	}

	@Override
	public String toString() {
		return "SomeEntity [someString=" + this.someString + ", someInteger="
				+ this.someInteger + ", someDate=" + this.someDate + "]";
	}

}
