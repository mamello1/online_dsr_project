package com.m3support.demo.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_project_employee_transactional")
public class Account_Project_Employee {
	
	 @ManyToOne
	 @JoinColumn(name = "account_id")
	 private Account account;
	 
	 @ManyToOne
	 @JoinColumn(name = "project_id")
	 private Project project;
	 
	 @ManyToOne
	 @JoinColumn(name = "emp_psid")
	 private Employee employee;

}
