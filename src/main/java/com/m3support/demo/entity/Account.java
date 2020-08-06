package com.m3support.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "account_master")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long id;
	
	@Column(name = "reporting_manager")
	private String reportingManager;
	
	@Column(name = "account_desc")
	private String accountDesc;
	
	@OneToMany(mappedBy = "account_master", 
	cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Project> project = new HashSet<>();
	
	@OneToMany(mappedBy = "account_master", 
	cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Report> report = new HashSet<>();
	
	@OneToMany(mappedBy = "account_master", 
	cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Account_Project_Employee> ape = new HashSet<>();
	
	//Account default constructor
	public Account() {
		
	}
	
	//Account constructor to access private variables
	public Account(Long id,String reportingManager,String accountDesc) {
		
		this.id = id;
		this.reportingManager = reportingManager;
		this.accountDesc = accountDesc;
	}
	
	
	//Set method for account id.
	public void setId(Long id) {
		
		this.id = id;
	}
	
	
	//Get method for account id.
	public Long getId() {
		
		return id;
	}
	
	//Set method for reporting manager.
	public void setReportingManager(String reportingManager) {
				
		this.reportingManager = reportingManager;		
	}
						
	//Get method for reporting manager.
	public String getReportingManager() {
				
		return reportingManager;		
	}
						
	//Set method for account description.
	public void setAccountDesc(String accountDesc) {
			
		this.accountDesc = accountDesc;		
	}
				
	//Get method for account description.
	public String getAccountDesc() {
			
	return accountDesc;	
	}
		
	
	@Override
	public String toString() {
		
	return "Accounts {" +
	
                "Account Id = " + id +
                
                ", Reporting Manager = '" + reportingManager + '\'' +
                
                ", Account Desc ='" + accountDesc + '\'' + 
                                
                '}';
		
	}
	        
	 

}


