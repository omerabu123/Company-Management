package com.companyManagment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.companyManagment.beans.Child;
import com.companyManagment.exception.CannotFindEntity;
import com.companyManagment.service.IChildServiceImpl;
import com.companyManagment.service.IEmployeeServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("child")
@Api(value = "ChildControllerApi")
@CrossOrigin("*")
public class ChildController {

	@Autowired
	private IChildServiceImpl childService;

	@GetMapping("getOneChild")
	@ApiOperation("Gets One Specific Child")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Child.class) })
	public ResponseEntity<Object> getOneChild(@RequestParam("childID") int childID) {
		try {
			return ResponseEntity.ok().body(childService.getOneChild(childID));
		} catch (CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("getOneChildByCitizenID")
	@ApiOperation("Gets One Specific Child By CitizenID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Child.class) })
	public ResponseEntity<Object> getOneChildByCitizenID(@RequestParam("citizenID") int citizenID) {
		try {
			return ResponseEntity.ok().body(childService.getChildByCitizenID(citizenID));
		} catch (CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("getAllChildren")
	@ApiOperation("Gets All Children In Company")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Child.class) })
	public ResponseEntity<Object> getAllCompanyChildren() {
		return ResponseEntity.ok().body(childService.getAllChildren());
	}

	
	@GetMapping("getChildrenByMinAge")
	@ApiOperation("Gets children all children within the age parameter")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Child.class) })
	public ResponseEntity<Object> getChildrenByAge(@RequestParam("age") double age){
		return ResponseEntity.ok().body(childService.getChildrenByMinAge(age));
	}

}
