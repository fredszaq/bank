package com.excilys.formation.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO delete this.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "SOME_ENTITY")
public class SomeEntity {

	@Id
	@Column(name = "SOME_STRING")
	private String someString;
	@Column(name = "SOME_INT")
	private int someInteger;
	@Column(name = "SOME_DATE")
	private Date someDate;

	public final Date getSomeDate() {
		return this.someDate;
	}

	public final int getSomeInteger() {
		return this.someInteger;
	}

	public final String getSomeString() {
		return this.someString;
	}

	public final void setSomeDate(Date someDate) {
		this.someDate = someDate;
	}

	public final void setSomeInteger(int someInteger) {
		this.someInteger = someInteger;
	}

	public final void setSomeString(String someString) {
		this.someString = someString;
	}

	@Override
	public final String toString() {
		return "SomeEntity [someString=" + this.someString + ", someInteger="
				+ this.someInteger + ", someDate=" + this.someDate + "]";
	}

}
