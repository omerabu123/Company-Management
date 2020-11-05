package com.companyManagment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyManagment.beans.Child;

@Repository
public class IChildrenRepositoryImpl {

	@Autowired
	private IChildrenRepository repo;

	public Child getChildrenByID(int id) {
		Optional<Child> opt = repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	public void addChild(Child child) {
		repo.save(child);
	}

	public void updateChild(Child child) {
		repo.save(child);
	}

	public void deleteChild(Child child) {
		repo.delete(child);
	}

	public Child getChildByCitizenID(long citizenID) {
		return repo.getChildByCitizenID(citizenID);
	}

	public List<Child> getAllChildren() {
		return repo.findAll();
	}

	public List<Child> getChildByMinAge(double age) {
		return repo.getChildByMinAge(age);
	}

}
