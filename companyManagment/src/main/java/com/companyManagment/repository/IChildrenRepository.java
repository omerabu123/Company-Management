package com.companyManagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.companyManagment.beans.Child;

public interface IChildrenRepository extends JpaRepository<Child, Integer>{

	@Query(nativeQuery = true,value = "select * from Child where General_Details_citizenid=?1")
	public Child getChildByCitizenID(long citizenID);

	@Query(nativeQuery = true,value = "select childid,life_stage,general_details_citizenid from Child Join general_details where Year(general_details.date_of_birth)<Year(CURRENT_TIMESTAMP)-?1")
	public List<Child> getChildByMinAge(double age);
}
