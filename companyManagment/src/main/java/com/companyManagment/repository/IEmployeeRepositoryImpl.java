package com.companyManagment.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.companyManagment.beans.Employee;
@Repository
public class IEmployeeRepositoryImpl {

	@Autowired
	private IEmployeeRepository repo;
	
	public Employee getOneEmployee(int employeeID) {
		Optional<Employee> opt=repo.findById(employeeID);
		if (opt.isPresent())
			return opt.get();
		return null;
	}
	
	public List<Employee> getEmployees(){
		return repo.findAll();
	}

	public Employee add(Employee employee) {
		return repo.save(employee);
	}
	
	public void update(Employee employee) {
		repo.save(employee);
	}

	public void deleteEmployee(int employeeID) {
		repo.deleteById(employeeID);
		
	}

	public void updateEmployee(Employee employee) {
		repo.saveAndFlush(employee);
	}

	public Employee getEmployeeCitizenID(long citizenID) {
		 return repo.getEmployeeByCitizenID(citizenID);
	}
}
