package com.example.empmgmtservice.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.empmgmtservice.enums.Gender;
import com.example.empmgmtservice.models.Employee;

public class EmployeeMapper implements RowMapper<Employee> {
	
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee emp = new Employee();
		
		emp.setEmpId(rs.getInt("emp_id"));
		emp.setFirstName(rs.getString("first_name"));
		emp.setLastName(rs.getString("last_name"));
		emp.setDateOfBirth(rs.getDate("date_of_birth"));
		emp.setGender(Gender.valueOf(rs.getString("EnumColumn")));
		emp.setHireDate(rs.getDate("hire_date"));
		
		return emp;
	}

}
