package com.companyManagment.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.companyManagment.beans.Child;
import com.companyManagment.beans.Employee;
import com.companyManagment.beans.Spouse;
import com.companyManagment.dto.EmployeeDTO;
import com.companyManagment.exception.CannotFindEntity;
import com.companyManagment.exception.EmployeeExists;
import com.companyManagment.service.IEmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("employee")
@Api(value = "EmployeeControllerApi")
@CrossOrigin("*")
//produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

	@Autowired
	private IEmployeeServiceImpl employeeService;

	@GetMapping(value = "/getEmployee", produces = MediaTypes.HAL_JSON_VALUE)
	@ApiOperation("Gets all company employees")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = EmployeeDTO.class) })
	public ResponseEntity<Object> getEmployees() {
		List<EmployeeDTO> employees = employeeService.getEmployeesDTO();
		return ResponseEntity.ok().body(employees);
	}

	@GetMapping(value = "/getOneEmployee", produces = MediaTypes.HAL_JSON_VALUE)
	@ApiOperation("Gets One Specific Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = EmployeeDTO.class) })
	public ResponseEntity<Object> getEmployeeByID(@RequestParam("employeeID") int employeeID) {
		try {
			EmployeeDTO emp = employeeService.getOneEmployeeDTO(employeeID);
			return ResponseEntity.ok().body(emp);
		} catch (CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/addEmployee")
	@ApiOperation("Add employee to company")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Long.class) })
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		try {
		return ResponseEntity.ok().body("created with id:" + employeeService.addEmployee(employee));
	} catch (EmployeeExists e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	}

	@DeleteMapping("/deleteEmployee")
	@ApiOperation("Delete employee from company")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class) })
	public ResponseEntity<Object> deleteEmployee(@RequestParam("employeeID") int employeeID) {
		try {
			employeeService.deleteEmployee(employeeID);
			return ResponseEntity.ok().body("Employee Deleted!");
		} catch (CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("updateEmployee")
	@ApiOperation("Update employee details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class) })
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		try {
			employeeService.updateEmployee(employee);
		} catch (CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().body("Employee details Updated.");
	}

	@GetMapping("getEmployeesByName")
	@ApiOperation("Gets employees that contains this String in their names.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = EmployeeDTO.class) })
	public ResponseEntity<Object> getEmployeesContainsName(@RequestParam("name") String name) {
		if (employeeService.getEmployeesByNameContaining(name).size() == 0)
			return ResponseEntity.ok().body("No employees with this name/letters !");
		return ResponseEntity.ok().body(employeeService.getEmployeesByNameContaining(name));
	}
}
