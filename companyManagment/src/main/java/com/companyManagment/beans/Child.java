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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Child extends RepresentationModel<Child> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int childID; 
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private GeneralDetails generalDetails;	
	@Column
	private String lifeStage;
	
	public Child() {}
	
	public Child(GeneralDetails generalDetails, String lifeStage) {
		super();
		this.generalDetails = generalDetails;
		this.lifeStage = lifeStage;
	}
	

	public int getChildID() {
		return childID;
	}

	public GeneralDetails getGeneralDetails() {
		return generalDetails;
	}

	public void setGeneralDetails(GeneralDetails generalDetails) {
		this.generalDetails = generalDetails;
	}

	public String getLifeStage() {
		return lifeStage;
	}

	public void setLifeStage(String lifeStage) {
		this.lifeStage = lifeStage;
	}

	@Override
	public String toString() {
		return "Child [childID=" + childID + ", generalDetails=" + generalDetails + ", lifeStage=" + lifeStage + "]";
	}
	
	
	
}
