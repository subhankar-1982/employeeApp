package com.details.employee.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4132439071178673733L;
	
	Integer emplyeeId;
	
	String fname;
	
	String lname;
	
	Double yearlySalary;
	
	Double taxAmount;
	
	Double cessAmount;

}
