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
@Table(name = "employee_master")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_psid")
	private Long id;
	
	@Column(name = "emp_firstname")
	private String empFirstname;
	
	@Column(name = "emp_username")
	private String empUsername;
	
	@Column(name = "emp_password")
	private String empPassword;
	
	@OneToMany(mappedBy = "employee_master", 
	cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Report> report = new HashSet<>();
	
	@OneToMany(mappedBy = "employee_master", 
	cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Account_Project_Employee> ape = new HashSet<>();
	
	
	public Employee() {
		
	}
	
	public Employee(Long id,String empFirstname,String empUsername,String empPassword ) {
		
		this.id = id;
		this.empFirstname = empFirstname;
		this.empUsername  = empUsername;
		this.empPassword = empPassword;
		
	}
	
	//Set method for project id.
	public void setId(Long id) {
			
			this.id = id;
		}
		
		
	//Get method for project id.
	public Long getId() {
			
			return id;
	}
		
	//Set method for employee firstname.
	public void setFirstname(String empFirstname) {
					
			this.empFirstname = empFirstname;		
		}
							
	//Get method for employee firstname.
	public String getFirstname() {
					
			return empFirstname;		
		}
							
	//Set method for employee username.
	public void setUsername(String empUsername) {
				
			this.empUsername = empUsername;		
		}
					
	//Get method for  employee username.
	public String getUsername() {
				
		return empUsername;
		
		}
	
	//Set method for project description.
		public void setPassword(String empPassword) {
					
				this.empPassword = empPassword;		
			}
						
		//Get method for project description.
		public String getPassword() {
					
			return empPassword;
			
			}
			
		
		@Override
		public String toString() {
			
		return "Employee{" +
		
	                "Employee Id = " + id +
	                
	                ", Employee Firstname = '" + empFirstname + '\'' +
	                
	                ", Employee Username ='" + empUsername + '\'' + 
	                
	                 ", Employee Password ='" + empPassword + '\'' + 
	                                
	                '}';
			
		}

	
	
	

}
