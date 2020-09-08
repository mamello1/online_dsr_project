package com.m3support.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3support.demo.dtos.AccountDto;
import com.m3support.demo.dtos.AccountIdDto;
import com.m3support.demo.dtos.EmployeeDto;
import com.m3support.demo.dtos.ProjectDto;
import com.m3support.demo.entity.Account;
import com.m3support.demo.entity.Project;
import com.m3support.demo.entity.Report;
import com.m3support.demo.service.AccountService;
import com.m3support.demo.service.EmployeeService;
import com.m3support.demo.service.ProjectService;
import com.m3support.demo.service.ReportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	ReportService reportService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService employeeService;
				
	
	//Method used to create an account.
	@PostMapping("/admin/createAccount")
	public void createAccount(@RequestBody Account account) {
				 
		 this.accountService.createAccount(account);;
			
	}
	
	//Method used to update an account
	@PutMapping("/admin/updateAccount")
	public void updateAccount(@RequestBody Account account) {
		this.accountService.updateAccount(account);
	}
	
	
	//Method to view all accounts.
	@GetMapping("/admin/viewAccounts")
	public List<Account> getAllAccounts(){
			
		return accountService.getAllAccounts();
		
	}
			
	//Method to view all employees submitted reports.
	@GetMapping("/admin/viewReports")
	public List<Report> getAllDSRReports(){
		
		return reportService.getAllDSRReports();
	}
	
	
	//Method that allows the manager to retrieve/view all projects.
	@GetMapping("/admin/viewProjects")
	public List<Project> getAllProjects(){
				
		return projectService.getAllProjects();
		
	}
	
	//Method used to retrieve account dashboard details.
	@GetMapping("/admin/accountsDashboard")
	public List<AccountDto> accountsDashboard() {

		return accountService.getAccountsDashboard();

	}
	
	//Method used to retrieve project dashboard details
	@GetMapping("/admin/projectsDashboard")
	public List<ProjectDto> getProjectsDashboard() {
		
		return this.projectService.getProjectsDashboard();
				
	}
	
	//Method used to retrieve account identifier details
	@GetMapping("/admin/accountIdentifiers")
	public List<AccountIdDto> accountIdentifiers() {
		return accountService.getAccountsForProjects();
	}


	// Method that retrieves employee details by the employee email_id .
	@GetMapping("/admin/employeeDashboard/{emp_email}")
	public List<EmployeeDto> employeeDashboard(@PathVariable("emp_email") String emp_email) {

		return employeeService.getEmployeeDashboard(emp_email);

	}
	
	@PutMapping("/admin/updateProject/{accountId}/{projectId}")
	public void updateProject(@PathVariable("accountId") int accountId, @PathVariable("projectId") int projectId,
			@RequestBody Project project) {
		this.projectService.updateProject(accountId, projectId, project);
	}

	@PostMapping("/admin/createproject/{accountId}")
	public void createProject(@PathVariable("accountId") int accountId, @RequestBody Project project) {
		this.projectService.createProject(accountId, project);
	}


}
