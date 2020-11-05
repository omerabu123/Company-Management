package com.companyManagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.companyManagment.beans.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query(nativeQuery = true,value = "select * from Employee where General_Details_citizenid=?1")
	public Employee getEmployeeByCitizenID(long citizenID);
}
