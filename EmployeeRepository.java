package com.details.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.details.employee.model.Employee;

import com.details.employee.model.EmployeeView;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	@Query(value="select \r\n"
			+ "   emp.employee_id as empCode,\r\n"
			+ "   emp.fname as firstName,\r\n"
			+ "   emp.lname as lastName,\r\n"
			+ "   sum(case\r\n"
			+ "         when EXTRACT(MONTH FROM emp.doj)<5 then emp.salary\r\n"
			+ "		 when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		 else emp.salary\r\n"
			+ "		 end)as yearlySalary,\r\n"
			+ "   \r\n"
			+ "   CASE WHEN sum(case\r\n"
			+ "         when EXTRACT(MONTH FROM emp.doj)<5 then emp.salary\r\n"
			+ "		 when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		 else 0\r\n"
			+ "		 end)<=250000 then 0\r\n"
			+ "		 \r\n"
			+ "	    WHEN SUM(case\r\n"
			+ "         when EXTRACT(MONTH FROM emp.doj)<5 then emp.salary\r\n"
			+ "		 when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		 else 0\r\n"
			+ "		 end)>250000 AND SUM(\r\n"
			+ "		   case\r\n"
			+ "           when EXTRACT(MONTH FROM emp.doj)<5 then emp.salary\r\n"
			+ "		   when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		   else 0\r\n"
			+ "		   end\r\n"
			+ "		 ) < 500000\r\n"
			+ "		 then (SUM(case\r\n"
			+ "           when EXTRACT(MONTH FROM emp.doj)<5 then emp.salary\r\n"
			+ "		   when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		   else 0\r\n"
			+ "		   end)-250000) * 0.05\r\n"
			+ "		 WHEN SUM(case\r\n"
			+ "         when EXTRACT(MONTH FROM emp.doj)<5 then salary\r\n"
			+ "		 when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		 else 0\r\n"
			+ "		 end)>500000 AND SUM(\r\n"
			+ "		   case\r\n"
			+ "           when EXTRACT(MONTH FROM emp.doj)<5 then emp.salary\r\n"
			+ "		   when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		   else 0\r\n"
			+ "		   end\r\n"
			+ "		 ) < 1000000\r\n"
			+ "		 then (SUM(case\r\n"
			+ "           when EXTRACT(MONTH FROM emp.doj)<5 then salary\r\n"
			+ "		   when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		   else 0\r\n"
			+ "		   end)-500000) * 0.1\r\n"
			+ "		   \r\n"
			+ "		 WHEN SUM(case\r\n"
			+ "         when EXTRACT(MONTH FROM emp.doj)<5 then emp.salary\r\n"
			+ "		 when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		 else 0\r\n"
			+ "		 end)>1000000 \r\n"
			+ "		 then (SUM(case\r\n"
			+ "           when EXTRACT(MONTH FROM emp.doj)<5 then salary\r\n"
			+ "		   when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		   else 0\r\n"
			+ "		   end)-1000000) * 0.2\r\n"
			+ "	END as taxAmount,\r\n"
			+ "   \r\n"
			+ "   case when SUM(case\r\n"
			+ "         when EXTRACT(MONTH FROM emp.doj)<5 then salary\r\n"
			+ "		 when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		 else 0\r\n"
			+ "		 end) > 250000\r\n"
			+ "    THEN (SUM(case\r\n"
			+ "           when EXTRACT(MONTH FROM emp.doj)<5 then emp.salary\r\n"
			+ "		   when EXTRACT(MONTH FROM emp.doj)=5 and EXTRACT(DAY FROM doj)>15 then emp.salary\r\n"
			+ "		   else 0\r\n"
			+ "		   end)-250000) * 0.02\r\n"
			+ "     END as cessAmount		   \r\n"
			+ "	 \r\n"
			+ "	 from employee emp group by emp.employee_id, emp.fname,\r\n"
			+ "  emp.lname",nativeQuery = true)
	List<EmployeeView> fetchAllEmployee();
	

}
