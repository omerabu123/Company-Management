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

import com.companyManagment.beans.Spouse;
import com.companyManagment.exception.CannotFindEntity;
import com.companyManagment.service.ISpouseServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("spouse")
@Api(value = "SpouseControllerApi")
@CrossOrigin("*")
public class SpouseController {

	@Autowired
	private ISpouseServiceImpl spouseService;

	@GetMapping("/getOneSpouse")
	@ApiOperation("Gets One Specific Spouse")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Spouse.class) })
	public ResponseEntity<Object> getOneSpouse(@RequestParam("spouseID") int spouseID) {
		try {
			return ResponseEntity.ok().body(spouseService.getOneSpouse(spouseID));			
		} catch (CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/getOneSpouseByCitizenID")
	@ApiOperation("Gets One Specific Spouse By CitizenID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Spouse.class) })
	public ResponseEntity<Object> getOneSpouseByCitizenID(@RequestParam("citizenID") int citizenID) {
		try {
			return ResponseEntity.ok().body(spouseService.getSpouseByCitizenID(citizenID));			
		} catch (CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("updateSpouseName")
	@ApiOperation("Update Spouse Name")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK",response = String.class)})
	public ResponseEntity<Object> updateSpouse(@RequestParam("spouseID") int spouseID,@RequestParam("spouseName") String name){
		try {
		spouseService.updateSpouseName(spouseID,name);
		return ResponseEntity.ok().body("Spouse updated");
		} catch(CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("getAllSpouses")
	@ApiOperation("Get all company employee Spouses!")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK",response = Spouse.class)})
	public ResponseEntity<Object> updateSpouse(){
		return ResponseEntity.ok().body(spouseService.getAllSpouses());
	}
}