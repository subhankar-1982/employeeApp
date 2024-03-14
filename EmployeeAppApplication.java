package com.details.employee;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.details.employee.dto.EmployeeDto;
import com.details.employee.service.EmployeeDetails;

@SpringBootApplication
public class EmployeeAppApplication implements CommandLineRunner{

	@Autowired
	EmployeeDetails employeeDetails;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		EmployeeDto empDto=new EmployeeDto();
		empDto.setAddress("C602 Bhagwatishilp");
		
		empDto.setDoj(parseDateSting("18-Jan-2021"));
		empDto.setEmail("jobs.subhankar1982@gmail.com");
		empDto.setFname("Subhankar");
		empDto.setLname("Chakraborty");
		empDto.setPhone_num("8512023075,8760089902");
		empDto.setSalary(1200000.34d);
		
		employeeDetails.saveEmployeeDetails(empDto);
		EmployeeDto empDto2=new EmployeeDto();
		empDto2.setAddress("M91 Mayurbihar phase 3");
		
		empDto2.setDoj(parseDateSting("28-Oct-2021"));
		empDto2.setEmail("sameer_c@gmail.com");
		empDto2.setFname("Sameer");
		empDto2.setLname("Sabat");
		empDto2.setPhone_num("8512023079,8960089902");
		empDto2.setSalary(1200000.34d);
		
		employeeDetails.saveEmployeeDetails(empDto2);
		
		EmployeeDto empDto3=new EmployeeDto();
		empDto3.setAddress("Hinjewadi Brindawan niwas QNo:32");
		
		empDto3.setDoj(parseDateSting("09-Feb-2021"));
		empDto3.setEmail("krunal.gunatra@gmail.com");
		empDto3.setFname("Krunal");
		empDto3.setLname("Gunatra");
		empDto3.setPhone_num("6712023079,8360088002");
		empDto3.setSalary(700000.34d);
		
		employeeDetails.saveEmployeeDetails(empDto3);
	
		
	}
	
	static Date parseDateSting(String dateString) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		try {
			return sdf.parse(dateString);
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
