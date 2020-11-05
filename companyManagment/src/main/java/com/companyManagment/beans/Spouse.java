package com.companyManagment.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.hateoas.RepresentationModel;
@Entity
public class Spouse extends RepresentationModel<Spouse>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spouseID;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private GeneralDetails generalDetails;
	@Column
	private double yearsOfMarriage;
	
	public Spouse() {}

	
	
	public Spouse(int spouseID, GeneralDetails generalDetails, double yearsOfMarriage) {
		super();
		this.spouseID = spouseID;
		this.generalDetails = generalDetails;
		this.yearsOfMarriage = yearsOfMarriage;
	}



	public Spouse(GeneralDetails generalDetails, double yearsOfMarriage) {
		super();
		this.generalDetails = generalDetails;
		this.yearsOfMarriage = yearsOfMarriage;
	}

	public int getSpouseID() {
		return spouseID;
	}
	public GeneralDetails getGeneralDetails() {
		return generalDetails;
	}

	public void setGeneralDetails(GeneralDetails generalDetails) {
		this.generalDetails = generalDetails;
	}

	public double getYearsOfMarriage() {
		return yearsOfMarriage;
	}

	public void setYearsOfMarriage(double yearsOfMarriage) {
		this.yearsOfMarriage = yearsOfMarriage;
	}

	@Override
	public String toString() {
		return "Spouse [spouseID=" + spouseID + ", generalDetails=" + generalDetails + ", yearsOfMarriage="
				+ yearsOfMarriage + "]";
	}
	
}
