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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project_master")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long id;
	
	@Column(name = "reporting_manager")
	private String reportingManager;
	
	@Column(name = "project_desc")
	private String projectDesc;
	
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    
    @OneToMany(mappedBy = "project_master", 
    cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Report> report = new HashSet<>();
    		
    @OneToMany(mappedBy = "project_master", 
    cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Account_Project_Employee> ape = new HashSet<>();
    		
		
	//Account default constructor
	public Project() {
		
	}
	
	//Account constructor to access private variables
	public Project(Long id,String reportingManager,String projectDesc) {
		
		this.id = id;
		this.reportingManager = reportingManager;
		this.projectDesc = projectDesc;
	}
	
	
	//Set method for project id.
	public void setId(Long id) {
		
		this.id = id;
	}
	
	
	//Get method for project id.
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
						
	//Set method for project description.
	public void setProjectDesc(String projectDesc) {
			
		this.projectDesc = projectDesc;		
	}
				
	//Get method for project description.
	public String getProjectDesc() {
			
	return projectDesc;	
	}
		
	
	@Override
	public String toString() {
		
	return "Project{" +
	
                "Project Id = " + id +
                
                ", Reporting Manager = '" + reportingManager + '\'' +
                
                ", Project Desc='" + projectDesc + '\'' + 
                                
                '}';
		
	}
	

}
