package com.details.employee.service;

import java.util.List;

import com.details.employee.dto.EmployeeDetailResponse;
import com.details.employee.dto.EmployeeDto;

public interface EmployeeDetails {
	
	List<EmployeeDetailResponse> getAllEmployee();
	
	
	EmployeeDto saveEmployeeDetails(EmployeeDto empDto);

}
