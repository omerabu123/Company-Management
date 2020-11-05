package com.companyManagment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.h2.engine.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import com.companyManagment.beans.Adress;
import com.companyManagment.beans.Child;
import com.companyManagment.beans.Employee;
import com.companyManagment.beans.Spouse;
import com.companyManagment.dto.EmployeeDTO;
import com.companyManagment.exception.CannotFindEntity;
import com.companyManagment.exception.EmployeeExists;
import com.companyManagment.repository.IChildrenRepositoryImpl;
import com.companyManagment.repository.IEmployeeRepository;
import com.companyManagment.repository.IEmployeeRepositoryImpl;
import com.companyManagment.repository.ISpouseRepositoryImpl;
import com.companyManagment.web.ChildController;
import com.companyManagment.web.EmployeeController;
import com.companyManagment.web.SpouseController;

@Service
@Primary
public class IEmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepositoryImpl employeeDB;

	@Override
	public List<Employee> getEmployees() {
		return employeeDB.getEmployees();
	}

	@Override
	public List<EmployeeDTO> getEmployeesDTO() {
		List<EmployeeDTO> employeesDTO = new ArrayList<>();
		for (Employee employee : getEmployees()) {
			employeesDTO.add(fromemployeeToDTO(employee));
		}
		return employeesDTO;
	}

	@Override
	public EmployeeDTO getOneEmployeeDTO(int employeeID) throws CannotFindEntity {
		Employee e = employeeDB.getOneEmployee(employeeID);
		if (e == null)
			throw new CannotFindEntity("Employee cannot be found.");
		return fromemployeeToDTO(e);
	}

	@Override
	public Employee addEmployee(Employee employee) throws EmployeeExists {
		if (employeeDB.getEmployeeCitizenID(employee.getGeneralDetails().getCitizenID()) == null) {
			System.out.println("New Employee!");
			return employeeDB.add(employee);
		}
		throw new EmployeeExists();
	}

	@Override
	public void deleteEmployee(int employeeID) throws CannotFindEntity {
		if (employeeDB.getOneEmployee(employeeID) == null)
			throw new CannotFindEntity("Employee cannot be found.");
		employeeDB.deleteEmployee(employeeID);
	}

	@Override
	public void updateEmployee(Employee employee) throws CannotFindEntity {
		if (employeeDB.getEmployeeCitizenID(employee.getGeneralDetails().getCitizenID()) == null)
			throw new CannotFindEntity("Employee cannot be found.");
		employeeDB.updateEmployee(employee);
	}

	public EmployeeDTO fromemployeeToDTO(Employee employee) {
		String[] childrenNames = new String[employee.getChildren().size()];
		int i = 0;
		Link childLink;
		for (Child child : employee.getChildren()) {
			childrenNames[i] = child.getGeneralDetails().getName();
			i++;
			childLink = WebMvcLinkBuilder.linkTo(ChildController.class).slash("getOneChild?childID=" + child.getChildID())
					.withRel("To Child Page");
			child.add(childLink);
		}
		EmployeeDTO empDTO = new EmployeeDTO(employee.getEmployeeID(), employee.getGeneralDetails().getName(),
				employee.getAdress().getStreetName() + ", " + employee.getAdress().getStreetName() + ", "
						+ employee.getAdress().getApartmentNumber(),
				employee.getSpouse().getGeneralDetails().getName(), childrenNames);
		Link spouseLink = WebMvcLinkBuilder.linkTo(SpouseController.class)
				.slash("getOneSpouse?spouseID=" + employee.getSpouse().getSpouseID()).withRel("To Spouse Page");
		empDTO.add(spouseLink);
		for (Child child : employee.getChildren()) {
			empDTO.add(child.getLinks());
		}
		return empDTO;
	}

	public List<Employee> getEmployeesByNameContaining(String name) {
		List<Employee> employeesByName = new ArrayList<>();
		for (Employee employee : getEmployees()) {
			if (employee.getGeneralDetails().getName().contains(name)) {
				employeesByName.add(employee);
			}
		}
		return employeesByName;
	}
}
