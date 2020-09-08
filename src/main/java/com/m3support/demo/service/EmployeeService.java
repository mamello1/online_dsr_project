package com.m3support.demo.service;

import java.util.List;

import com.m3support.demo.dtos.EmployeeDto;

public interface EmployeeService {
	
   List<EmployeeDto> getEmployeeDashboard(String emp_email);


}
