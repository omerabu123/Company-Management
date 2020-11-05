package com.companyManagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.companyManagment.beans.Child;
import com.companyManagment.beans.Spouse;
import com.companyManagment.exception.CannotFindEntity;
import com.companyManagment.repository.IChildrenRepositoryImpl;
import com.companyManagment.web.ChildController;
import com.companyManagment.web.SpouseController;

@Service
public class IChildServiceImpl implements IChildService{

	@Autowired
	private IChildrenRepositoryImpl childDB;
	
	@Override
	public Child getOneChild(int id) throws CannotFindEntity{
		if (childDB.getChildrenByID(id)==null) {
			throw new CannotFindEntity("Child cannot be found");
		}
		return childDB.getChildrenByID(id);
	}

	@Override
	public Child getChildByCitizenID(long citizenID) throws CannotFindEntity {
		if (childDB.getChildByCitizenID(citizenID)==null)
			throw new CannotFindEntity("Child cannot be found");
		return childDB.getChildByCitizenID(citizenID);
	}

	public List<Child> getAllChildren() {
		List<Child> children=childDB.getAllChildren();
		for (Child child : children) {
			addLinkToChild(child);
		}
		return children;
	}

	public List<Child> getChildrenByMinAge(double age) {
		List<Child> childrenByAge=childDB.getChildByMinAge(age);
		for (Child child : childrenByAge) {
			addLinkToChild(child);
		}
		return childrenByAge;
	}
	
	private void addLinkToChild(Child child) {
		child.add(WebMvcLinkBuilder.linkTo(ChildController.class).slash("/getOneChild?childID="+child.getChildID()).withRel("To Child Page"));
	}
}
