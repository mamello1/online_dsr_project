package com.m3support.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3support.demo.entity.Project;
import com.m3support.demo.entity.Report;
import com.m3support.demo.service.ProjectService;
import com.m3support.demo.service.ReportService;



@RestController
@RequestMapping("/api")
public class ManagerController {
	
	@Autowired
	ReportService reportService;
	
	@Autowired
	ProjectService projectService;
	
	
	//Methods used by manager to generate a PDF report.
	@GetMapping("/manager/{currentDate}")
	public String generateDSRReport(@PathVariable("currentDate") Date currentDate) throws Exception{ 
		 
	    return reportService.generateDSRReport(currentDate);
	    
	}
		
	//Method that returns all projects.
	@GetMapping("/manager")
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
		
		return reportService.getEmploeyeeDSRUnderProjects(project_id);
		
	}

}
