package com.companyManagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.companyManagment.beans.Spouse;

public interface ISpouseRepository extends JpaRepository<Spouse, Integer>{

	
	@Query(nativeQuery = true,value = "select * from Spouse where General_Details_citizenid=?1")
	public Spouse getSpouseByCitizenID(long citizenID);

}
