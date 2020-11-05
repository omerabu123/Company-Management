package com.companyManagment.dto;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.companyManagment.beans.Adress;
import com.companyManagment.beans.Child;
import com.companyManagment.beans.Employee;
import com.companyManagment.web.ChildController;
import com.companyManagment.web.SpouseController;

public class EmployeeDTO extends RepresentationModel<EmployeeDTO>{

	private int employeeID;
	private String employeeName;
	private String employeeAdress;
	private String spouseName;
	private String[] childrenNames;
	
	
	public EmployeeDTO(int employeeID, String employeeName, String employeeAdress,
			String spouseName,String[] childrenNames) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeAdress = employeeAdress;
		this.spouseName = spouseName;
		this.childrenNames=childrenNames;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String[] getChildrenNames() {
		return childrenNames;
	}

	public void setChildrenNames(String[] childrenNames) {
		this.childrenNames = childrenNames;
	}

	public int getEmployeeID() {
		return employeeID;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public String getEmployeeAdress() {
		return employeeAdress;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID=employeeID;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName=employeeName;
	}
	
	public void setEmployeeAdress(String employeeAdress) {
		this.employeeAdress=employeeAdress;
	}
	
}
