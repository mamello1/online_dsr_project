package com.m3support.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3support.demo.entity.Project;
import com.m3support.demo.entity.Report;
import com.m3support.demo.service.AccountService;
import com.m3support.demo.service.ProjectService;
import com.m3support.demo.service.ReportService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ManagerController {
	
	@Autowired
	ReportService reportService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	AccountService accountService;
	
	
	//Methods used by manager to generate a PDF report.
	@GetMapping("/manager/{currentDate}")
	public String generateDSRReport(@PathVariable("currentDate") Date currentDate) throws Exception{ 
		 
	    return reportService.generateDSRReport(currentDate);
	    
	}
		
	//Method that allows the manager to retrieve/view all projects.
	@GetMapping("/manager/viewProjects")
	public List<Project> getAllProjects(){
			
		return projectService.getAllProjects();
	}
	
	
	//Method that returns all projects under an account.
	@GetMapping("/manager/viewAllProjectsUnderAccount/{account_id}")
	public List<Project> getAllProjectsUnderAccount(@PathVariable int account_id ){
		
		return projectService.getProjectsUnderAccount(account_id);
			
	}
	
	//Method that returns all employees DSR under specific project.
	@GetMapping("/manager/viewEmployeesUnderProject/{project_id}")
	public List<Report> getEmployeesDSRUnderProject(@PathVariable int project_id){
		
		return reportService.getEmployeeDSRUnderProjects(project_id);
		
	}
	
	
	//Method to retrieve an employees submitted reports by their employee id.
	@GetMapping("/manager/{emp_id}/{startDate}/{endDate}")
	public List<Report> getDSROfSpecificEmployeeByDateRange(@PathVariable ("emp_id") int emp_id,@PathVariable ("startDate") Date startDate,@PathVariable ("endDate") Date endDate){
				 
		return reportService.getDSROfSpecificEmployeeByDateRange(emp_id,startDate,endDate);
			
	}
	
	//Method to for a manager to retrieve a specific employees submitted reports by their employee id.
	@GetMapping("/manager/{emp_id}")
	public List<Report> getDSROfSpecificEmployee(@PathVariable int emp_id){
				 
			return reportService.getDSROfSpecificEmployee(emp_id);
			
	}
	

		

}
