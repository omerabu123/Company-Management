package com.companyManagment.exception;

public class EmployeeExists extends Exception {

	public EmployeeExists() {
		super("Employee allready exists in system.");
	}
}
