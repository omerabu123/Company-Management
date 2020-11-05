package com.companyManagment.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GeneralDetails {

	@Id
	private long citizenID;
	@Column
	private String name;
	@Column
	private Date dateOfBirth;
	@Column
	private GenderType gender;

	public GeneralDetails() {}
	public GeneralDetails(long citizenID,String name, Date dateOfBirth, GenderType gender) {
		super();
		this.citizenID=citizenID;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	public GeneralDetails(String name, Date dateOfBirth, GenderType gender) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public long getCitizenID() {
		return citizenID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "GeneralDetails [citizenID=" + citizenID + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + "]";
	}

	
}
