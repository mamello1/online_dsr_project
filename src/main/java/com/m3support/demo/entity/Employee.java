package com.m3support.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_master")
public class Employee{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_psid")
	private int emp_psid;
	
	
	@Column(name = "emp_firstname")
	private String emp_firstname;
	

	public Employee() {
		
	}

	public Employee(int emp_psid,String emp_firstname) {
		this.emp_psid = emp_psid;
		this.emp_firstname = emp_firstname;
	}

	public int getEmp_psid() {
		return emp_psid;
	}

	public void setEmp_psid(int emp_psid) {
		this.emp_psid = emp_psid;
	}


	public String getEmp_firstname() {
		return emp_firstname;
	}

	public void setEmp_firstname(String emp_firstname) {
		this.emp_firstname = emp_firstname;
	}

	
	@Override
	public String toString() {
		return "Employee [emp_psid=" + emp_psid + ", emp_firstname=" + emp_firstname + "]";
	}
	
	
}

