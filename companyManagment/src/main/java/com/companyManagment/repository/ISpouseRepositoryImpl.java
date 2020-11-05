package com.companyManagment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyManagment.beans.Spouse;

@Repository
public class ISpouseRepositoryImpl {

	@Autowired
	private ISpouseRepository repo;

	public void updateSpouse(Spouse spouse) {
		repo.save(spouse);
	}

	public void deleteSpouse(int id) {
		repo.deleteById(id);
	}
	
	public Spouse getSpouseByID(int id) {
		Optional<Spouse> opt=repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}
	
	public Spouse getSpouseByCitizenID(long citizenID) {
		return repo.getSpouseByCitizenID(citizenID);
	}

	public List<Spouse> getAllSpouses() {
		return repo.findAll();
	}
}
