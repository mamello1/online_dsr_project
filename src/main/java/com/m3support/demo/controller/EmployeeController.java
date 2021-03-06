package com.m3support.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3support.demo.entity.Report;
import com.m3support.demo.service.ReportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	ReportService reportService;
	
	//Method to retrieve an employees submitted reports by their employee id by a specific date range.
	@GetMapping("/employee/viewDSR/{emp_id}/{startDate}/{endDate}")
	public List<Report> getDSROfSpecificEmployeeByDateRange(@PathVariable ("emp_id") int emp_id, @PathVariable ("startDate") Date startDate, @PathVariable ("endDate") Date endDate){
				 
		 return reportService.getDSROfSpecificEmployeeByDateRange(emp_id,startDate,endDate);
			
	}
	

				
	//Method that allows an employee to submit their daily status report.
	@PostMapping("/employee/createDSR")
	public String createDSR(@RequestBody Report report) {
					 
		this.reportService.createDSR(report);
		 
		return "Report Has Been Successfully Created & Submitted.";
		
	}
		
		
}
