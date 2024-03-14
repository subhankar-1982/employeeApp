package com.details.employee.dto;

import java.io.Serializable;
import java.util.Date;

import com.details.employee.validation.util.Message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer employeeId;

	String fname;

	String lname;

	String address;

	Double salary;

	String email;

	Date doj;

	String phone_num;
	
}
