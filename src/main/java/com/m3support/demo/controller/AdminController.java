package com.m3support.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3support.demo.entity.Account;
import com.m3support.demo.entity.Project;
import com.m3support.demo.entity.Report;
import com.m3support.demo.service.AccountService;
import com.m3support.demo.service.ProjectService;
import com.m3support.demo.service.ReportService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	ReportService reportService;
	
	@Autowired
	ProjectService projectService;
	
	//Method that allows an administrator to add a account.
	@PostMapping("/admin/createAccount")
	public void createAccount(@RequestBody Account account) {
				 
		 this.accountService.createAccount(account);;
			
	}
	
	//Method to retrieve/view all accounts.
	@GetMapping("/admin/viewAccounts")
	public List<Account> getAllAccounts(){
			
		return accountService.getAllAccounts();
		
	}
			
	//Method to retrieve/view all employees submitted reports.
	@GetMapping("/admin/viewReports")
	public List<Report> getAllDSRReports(){
		
		return reportService.getAllDSRReports();
	}
	
	
	//Method that allows the manager to retrieve/view all projects.
	@GetMapping("/admin/viewProjects")
	public List<Project> getAllProjects(){
				
		return projectService.getAllProjects();
		
	}
		

}
