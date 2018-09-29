package com.test.retailstorediscountcalc;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Customer {
	private String id;
	private String name;
	private String cellNumber;
	private boolean isEmployee;
	private boolean isAffiliate;
	private Date dateOfJoining;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public boolean isAffiliate() {
		return isAffiliate;
	}

	public void setAffiliate(boolean isAffiliate) {
		this.isAffiliate = isAffiliate;
	}

	public boolean isReturningCustomer() {
		boolean isReturningCustomer = false;
		if (dateOfJoining != null) {
			LocalDate doj = dateOfJoining.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate now = LocalDate.now();
			isReturningCustomer = Period.between(doj, now).getYears() >= 2;
		}
		return isReturningCustomer;
	}
}
