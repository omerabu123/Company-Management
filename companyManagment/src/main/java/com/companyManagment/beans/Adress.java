package com.companyManagment.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adressID;
	@Column
	private String streetName;	
	@Column
	private int streetNumber;
	@Column
	private int apartmentNumber;
	
	public Adress() {}

	
	public Adress(String streetName, int streetNumber, int apartmentNumber) {
		super();
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.apartmentNumber = apartmentNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}


	@Override
	public String toString() {
		return "Adress [adressID=" + adressID + ", streetName=" + streetName + ", streetNumber=" + streetNumber
				+ ", apartmentNumber=" + apartmentNumber + "]";
	}
	
}
