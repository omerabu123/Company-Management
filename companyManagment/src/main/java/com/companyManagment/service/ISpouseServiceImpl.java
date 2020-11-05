package com.companyManagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import com.companyManagment.beans.Spouse;
import com.companyManagment.exception.CannotFindEntity;
import com.companyManagment.repository.ISpouseRepositoryImpl;
import com.companyManagment.web.ChildController;
import com.companyManagment.web.SpouseController;

@Service
public class ISpouseServiceImpl implements ISpouseService{

	@Autowired
	private ISpouseRepositoryImpl spouseDB;
	@Override
	public Spouse getOneSpouse(int id) throws CannotFindEntity{
		Spouse spouse=spouseDB.getSpouseByID(id);
		if (spouse==null)
			throw new CannotFindEntity("Spouse cannot be found");
		spouse.add(WebMvcLinkBuilder.linkTo(SpouseController.class).slash("/updateSpouseName?spouseID="+spouse.getSpouseID()+"&spouseName=").withRel("To Change Spouse Name"));
		return spouse;
	}
	@Override
	public void updateSpouseName(int spouseID,String spouseNewName) throws CannotFindEntity {
		if (spouseDB.getSpouseByID(spouseID)==null)
			throw new CannotFindEntity("Spouse cannot be found");
		Spouse spouse=getOneSpouse(spouseID);
		spouse.getGeneralDetails().setName(spouseNewName);
		spouseDB.updateSpouse(spouse);
	}
	
	@Override
	public Spouse getSpouseByCitizenID(long citizenID) throws CannotFindEntity {
		if (spouseDB.getSpouseByCitizenID(citizenID)==null)
			throw new CannotFindEntity("Spouse cannot be found");
		return spouseDB.getSpouseByCitizenID(citizenID);
	}
	
	public List<Spouse> getAllSpouses() {
		List<Spouse> spouses=spouseDB.getAllSpouses();
		for (Spouse spouse : spouses) {
			addLinkToSpousePage(spouse);
		}
		return spouses;
	}
	
	private void addLinkToSpousePage(Spouse spouse) {
		spouse.add(WebMvcLinkBuilder.linkTo(SpouseController.class).slash("/getOneSpouse?spouseID="+spouse.getSpouseID()).withRel("To Spouse Page"));
	}
//	private void addLinkToSpouseChangeName(Spouse spouse) {
//		spouse.add(WebMvcLinkBuilder.linkTo(SpouseController.class).slash("/updateSpouseName?spouseID="+spouse.getSpouseID()+"&spouseName=").withRel("To Change Spouse Name"));
//	}
}
