package com.companyManagment.exception;

public class CannotFindEntity extends Exception{

	public CannotFindEntity(String string) {
		super("Cannot Find Entity: "+string);
	}
}
