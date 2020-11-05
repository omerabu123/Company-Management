package com.companyManagment;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.companyManagment.beans.Adress;
import com.companyManagment.beans.Child;
import com.companyManagment.beans.Employee;
import com.companyManagment.beans.GenderType;
import com.companyManagment.beans.GeneralDetails;
import com.companyManagment.beans.Spouse;
import com.companyManagment.exception.EmployeeExists;
import com.companyManagment.repository.IEmployeeRepositoryImpl;
import com.companyManagment.service.IEmployeeServiceImpl;


@SpringBootTest
public class SpringBootAppTesting {
	
	@Autowired
	private IEmployeeServiceImpl employeeService;
	
	@MockBean
	private IEmployeeRepositoryImpl repo;
		
	@Test
	public void addEmployeeTest() {
		Adress adress=new Adress("Sumsum street",52,10);
		Spouse spouse=new Spouse(new GeneralDetails(6923993,"Lisa",new Date(1982, 14, 1),GenderType.Female),15);
		List<Child> children=new ArrayList<Child>();
		children.add(new Child(new GeneralDetails(12464434,"Nir",new Date(2002,10,3),GenderType.Male), "Military Service"));
		children.add(new Child(new GeneralDetails(1256323,"Noam",new Date(2008,4,2),GenderType.Female), "10th Grade"));
		Employee emp=new Employee(spouse,adress,children,new GeneralDetails(12526433,"Rami",new Date(1980,1,1),GenderType.Male));
			try {
				when(employeeService.addEmployee(emp)).thenReturn(emp);
			} catch (EmployeeExists e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void getEmployeesTest() {
		List<Employee> employees =new ArrayList<Employee>();
		Adress adress=new Adress("Sumsum street",52,10);
		Spouse spouse=new Spouse(new GeneralDetails(6923993,"Lisa",new Date(1982, 14, 1),GenderType.Female),15);
		List<Child> children=new ArrayList<Child>();
		children.add(new Child(new GeneralDetails(12464434,"Nir",new Date(2002,10,3),GenderType.Male), "Military Service"));
		children.add(new Child(new GeneralDetails(1256323,"Noam",new Date(2008,4,2),GenderType.Female), "10th Grade"));
		Employee emp=new Employee(spouse,adress,children,new GeneralDetails(12526433,"Rami",new Date(1980,1,1),GenderType.Male));
		Adress adress2=new Adress("Sumsum street",22,11);
		Spouse spouse2=new Spouse(new GeneralDetails(1111111,"Anna",new Date(1988, 11, 4),GenderType.Female),10);
		List<Child> children2=new ArrayList<Child>();
		children2.add(new Child(new GeneralDetails(1234567,"Gal",new Date(2010,5,7),GenderType.Male), "5th Grade"));
		children2.add(new Child(new GeneralDetails(1324567,"Neta",new Date(2014,3,1),GenderType.Female), "KinderGarden"));
		Employee emp2=new Employee(spouse2,adress2,children2,new GeneralDetails("Gil",new Date(1985,2,1),GenderType.Male));
		employees.addAll(Arrays.asList(emp,emp2));
		when(repo.getEmployees()).thenReturn(employees);
		assertEquals(2, employeeService.getEmployees().size());
	}
	
	@Test
	public void getEmployeesByName() {
		List<Employee> employees =new ArrayList<Employee>();
		Adress adress=new Adress("Sumsum street",52,10);
		Spouse spouse=new Spouse(new GeneralDetails(6923993,"Lisa",new Date(1982, 14, 1),GenderType.Female),15);
		List<Child> children=new ArrayList<Child>();
		children.add(new Child(new GeneralDetails(12464434,"Nir",new Date(2002,10,3),GenderType.Male), "Military Service"));
		children.add(new Child(new GeneralDetails(1256323,"Noam",new Date(2008,4,2),GenderType.Female), "10th Grade"));
		Employee emp=new Employee(spouse,adress,children,new GeneralDetails(12526433,"Rami",new Date(1980,1,1),GenderType.Male));
		Adress adress2=new Adress("Sumsum street",22,11);
		Spouse spouse2=new Spouse(new GeneralDetails(1111111,"Anna",new Date(1988, 11, 4),GenderType.Female),10);
		List<Child> children2=new ArrayList<Child>();
		children2.add(new Child(new GeneralDetails(1234567,"Gal",new Date(2010,5,7),GenderType.Male), "5th Grade"));
		children2.add(new Child(new GeneralDetails(1324567,"Neta",new Date(2014,3,1),GenderType.Female), "KinderGarden"));
		Employee emp2=new Employee(spouse2,adress2,children2,new GeneralDetails(5921752,"Gil",new Date(1985,2,1),GenderType.Male));
		employees.addAll(Arrays.asList(emp,emp2));
		when(employeeService.getEmployees()).thenReturn(employees);
		assertEquals(1, employeeService.getEmployeesByNameContaining(emp.getGeneralDetails().getName()).size());
	}
	
}
