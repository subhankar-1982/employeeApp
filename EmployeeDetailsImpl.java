package com.details.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.details.employee.dto.EmployeeDetailResponse;
import com.details.employee.dto.EmployeeDto;
import com.details.employee.model.Employee;
import com.details.employee.model.EmployeeView;
import com.details.employee.repository.EmployeeRepository;
import com.details.employee.service.EmployeeDetails;

@Service
public class EmployeeDetailsImpl implements EmployeeDetails {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDetailResponse> getAllEmployee() {
		List<EmployeeView> listOfEmplyeeDetails = employeeRepository.fetchAllEmployee();

		List<EmployeeDetailResponse> employeeDetailResponse = new ArrayList<>();
		if (listOfEmplyeeDetails != null && !listOfEmplyeeDetails.isEmpty()) {
			listOfEmplyeeDetails.stream().forEach(x -> {
				for (EmployeeView view : listOfEmplyeeDetails) {
					EmployeeDetailResponse response = new EmployeeDetailResponse();
					response.setEmplyeeId(view.getEmpCode());
					response.setFname(view.getFirstName());
					response.setLname(view.getLastName());
					response.setTaxAmount(view.getTaxAmount());
					response.setYearlySalary(view.getYearlySalary());
					response.setCessAmount(view.getCessAmount());
					employeeDetailResponse.add(response);
				}
			});
		}

		return employeeDetailResponse;
	}

	@Override
	@Transactional
	public EmployeeDto saveEmployeeDetails(EmployeeDto empDto) {
		
		Employee emp = new Employee();	
		BeanUtils.copyProperties(empDto, emp);
		emp = employeeRepository.save(emp);
		BeanUtils.copyProperties(emp, empDto);
		return empDto;
	}

}
