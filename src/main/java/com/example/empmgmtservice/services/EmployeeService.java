package com.example.empmgmtservice.services;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.empmgmtservice.mappers.EmployeeMapper;
import com.example.empmgmtservice.models.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	private static final String GET_EMPLOYEE_BY_ID = "SELECT emp_id, first_name, last_name, "
			+ " birth_date, gender, hire_date from employee where emp_id = :empId";
    private static final String GET_ALL_EMPLOYEES = "SELECT emp_id, first_name, last_name, "
    		+ " birth_date, gender, hire_date from employee";
    private static final String ADD_EMPLOYEE = "INSERT INTO EMPLOYEE(BIRTH_DATE, FIRST_NAME, LAST_NAME, GENDER, HIRE_DATE) "
    		+ " values (:birthDate, :firstName, :lastName, :gender, :hireDate)";
    
    public List<Employee> getListOfAllEmployee() {
    	return this.namedJdbcTemplate.query(GET_ALL_EMPLOYEES, new EmployeeMapper());
    }
    
    public Employee getEmployee(int id) {
    	MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("empId", id);
		
		return this.namedJdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID, param, new EmployeeMapper());
    }
    
    public int addEmployee(Employee emp) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	
    	MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("birthDate",  emp.getDateOfBirth());
		param.addValue("firstName", emp.getFirstName());
		param.addValue("lastName", emp.getLastName());
		param.addValue("gender", emp.getGender());
		param.addValue("hireDate", emp.getHireDate());
		
		return this.namedJdbcTemplate.update(ADD_EMPLOYEE, param);
    }

}
