package com.m3support.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3support.demo.entity.Report;
import com.m3support.demo.service.ReportService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	ReportService reportService;
	
	//Method to retrieve all employees submitted reports.
	@GetMapping("/employee")
	public List<Report> getAllDSRReports(){
		
		return reportService.getAllDSRReports();
	}
	
	
	//Method to for a manager to retrieve a specific employees submitted reports by their employee id.
	@GetMapping("/employee/{emp_psid}")
	public List<Report> getDSROfSpecificEmployee(@PathVariable int emp_psid){
			 
		return reportService.getDSROfSpecificEmployee(emp_psid);
		
	}
	
	//Method to retrieve an employees submitted reports by their employee id.
	@GetMapping("/employee/{emp_psid}/{startDate}/{endDate}")
	public List<Report> getDSROfSpecificEmployeeByDateRange(@PathVariable ("emp_psid") int emp_psid,@PathVariable ("startDate") Date startDate,@PathVariable ("endDate") Date endDate){
				 
		return reportService.getDSROfSpecificEmployeeByDateRange(emp_psid,startDate,endDate);
			
	}
				
	//Method that allows an employee to submit their daily report.
	@PostMapping("/employee")
	public void createDSR(@RequestBody Report report) {
					 
		 this.reportService.createDSR(report);
		
	}
	
	
		
	
	
	

}
