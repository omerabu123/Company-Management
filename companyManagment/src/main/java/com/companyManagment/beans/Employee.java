package com.companyManagment.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.hateoas.RepresentationModel;

@Entity
public class Employee{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeID;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Spouse spouse;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Adress adress;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Child> children;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private GeneralDetails generalDetails;

	public Employee() {
	}

	public Employee(int employeeID, Spouse spouse, Adress adress, List<Child> children, GeneralDetails generalDetails) {
		super();
		this.employeeID = employeeID;
		this.spouse = spouse;
		this.adress = adress;
		this.children = children;
		this.generalDetails = generalDetails;
	}

	public Employee(Spouse spouse, Adress adress, List<Child> children, GeneralDetails generalDetails) {
		super();
		this.spouse = spouse;
		this.adress = adress;
		this.children = children;
		this.generalDetails = generalDetails;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public Spouse getSpouse() {
		return spouse;
	}

	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	public GeneralDetails getGeneralDetails() {
		return generalDetails;
	}

	public void setGeneralDetails(GeneralDetails generalDetails) {
		this.generalDetails = generalDetails;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Employee) {
			Employee other = (Employee) o;
			if (employeeID !=other.getEmployeeID()) {
				if (generalDetails.getCitizenID() == other.getGeneralDetails().getCitizenID())
					return true;
			}
		}
		return false;
	}

	@Override
    public int hashCode() {
        int hash = 7;
        hash = 12 * hash + (this.generalDetails.getCitizenID() != 0 ? this.generalDetails.hashCode() : 0);
        return hash;
    }
	
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", spouse=" + spouse + ", adress=" + adress + ", children="
				+ children + ", generalDetails=" + generalDetails + "]";
	}

}
