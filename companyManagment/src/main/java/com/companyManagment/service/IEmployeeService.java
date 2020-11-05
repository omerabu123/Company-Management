package com.companyManagment.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.companyManagment.beans.Employee;
import com.companyManagment.dto.EmployeeDTO;
import com.companyManagment.exception.CannotFindEntity;
import com.companyManagment.exception.EmployeeExists;
@Service
public interface IEmployeeService {

	public List<Employee> getEmployees();
	public List<EmployeeDTO> getEmployeesDTO();
	public EmployeeDTO getOneEmployeeDTO(int employeeID) throws CannotFindEntity;
	public Employee addEmployee(Employee employee) throws EmployeeExists;
	public void deleteEmployee(int employeeID) throws CannotFindEntity;
	public void updateEmployee(Employee employee) throws CannotFindEntity;
 }
