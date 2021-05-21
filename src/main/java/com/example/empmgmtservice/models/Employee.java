package com.example.empmgmtservice.models;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.empmgmtservice.enums.Gender;

@Component
public class Employee {
	
	private int empId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Enum<Gender> gender;
	private Date hireDate;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Enum<Gender> getGender() {
		return gender;
	}
	public void setGender(Enum<Gender> gender) {
		this.gender = gender;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

}
