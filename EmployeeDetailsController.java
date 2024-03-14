package com.details.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.details.employee.dto.EmployeeDetailResponse;
import com.details.employee.dto.EmployeeDto;
import com.details.employee.exception.InvalidInputDetailsException;
import com.details.employee.service.EmployeeDetails;
import com.details.employee.validation.util.EmployeeFieldValidationUtil;
import com.details.employee.validation.util.Message;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/emp")
public class EmployeeDetailsController {

	@Autowired
	EmployeeDetails employeeDetails;

	@GetMapping("/all")
	@ApiOperation("Get all employee include there tax details")
	public ResponseEntity<List<EmployeeDetailResponse>> getDetails() {

		List<EmployeeDetailResponse> listEmployee = employeeDetails.getAllEmployee();

		return new ResponseEntity<>(listEmployee, HttpStatus.OK);
		
	}

	@PostMapping("/adddetails")
	@ApiOperation("Save employee")
	public ResponseEntity<EmployeeDto> saveEmployeeDetails(@RequestBody EmployeeDto empDetails) throws InvalidInputDetailsException {
		
		Message message = EmployeeFieldValidationUtil.validateEmployee(empDetails);
		if (message.isStatusFlag()) {
			throw new InvalidInputDetailsException(message);
     	}
		EmployeeDto savedDetails=employeeDetails.saveEmployeeDetails(empDetails);
		
		return new ResponseEntity<>(savedDetails, HttpStatus.OK);

	}
	
}
