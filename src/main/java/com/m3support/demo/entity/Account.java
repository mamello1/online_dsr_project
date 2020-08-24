package com.m3support.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_master")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int account_id;
	
	@Column(name = "account_desc")
	private String account_desc;
	
	@Column(name = "reporting_manager")
	private String reporting_manager;
	
	
	//Account default constructor
	public Account() {
		
	}

	public Account(int account_id, String account_desc,String reporting_manager) {
		this.account_id = account_id;
		this.account_desc = account_desc;
		this.reporting_manager = reporting_manager;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getAccount_desc() {
		return account_desc;
	}

	public void setAccount_desc(String account_desc) {
		this.account_desc = account_desc;
	}
	
	public String getReporting_manager() {
		return reporting_manager;
	}

	public void setReporting_manager(String reporting_manager) {
		this.reporting_manager = reporting_manager;
	}
	

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_desc=" + account_desc + ",reporting_manager=" + reporting_manager + "]";
	}
	
		        
	

}
