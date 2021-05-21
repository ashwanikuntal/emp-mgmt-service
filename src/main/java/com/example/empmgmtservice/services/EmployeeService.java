package com.example.empmgmtservice.services;

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
	
	private static final String GET_EMPLOYEE_BY_ID = "SELECT actor_id, first_name, last_name, "
			+ " date_of_birth, gender, hire_date from employee where actor_id = :empId";
    private static final String GET_ALL_EMPLOYEES = "SELECT emp_id, first_name, last_name, "
    		+ " date_of_birth, gender, hire_date from employee";
    
    public List<Employee> getListOfAllEmployee() {
    	return this.namedJdbcTemplate.query(GET_ALL_EMPLOYEES, new EmployeeMapper());
    }
    
    public Employee getEmployee(int id) {
    	MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("empId", id);
		
		return this.namedJdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID, param, new EmployeeMapper());
    }

}
