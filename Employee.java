package com.details.employee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	Integer employeeId;
	
	
	@Column(name="fname")
	String fname;
	
	@Column(name="lname")
	String lname;
	
	@Column(name="address")
	String address;
	
	@Column(name="salary")
	Double salary;
	
	@Column(name="email")
	String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="doj")
	Date doj;
	
	@Column(name="phone_num")
	String phone_num;
	

}
