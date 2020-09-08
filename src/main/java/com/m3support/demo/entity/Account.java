package com.m3support.demo.entity;

import java.sql.Date;

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
	
	@Column(name = "reporting_manager")
	private String reporting_manager;
	
	@Column(name = "account_desc")
	private String account_desc;
	
	@Column(name = "deleted")
	private boolean deleted = false;

	@Column(name = "createdOn")
	private Date createdOn;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "modifiedOn")
	private Date modifiedOn;

	@Column(name = "modifiedBy")
	private String modifiedBy;

	
	
	//Account default constructor
	public Account() {
		
	}

	

	public Account(int account_id, String account_desc, String reporting_manager, boolean deleted, Date createdOn,
			String createdBy, Date modifiedOn, String modifiedBy) {
		this.account_id = account_id;
		this.account_desc = account_desc;
		this.reporting_manager = reporting_manager;
		this.deleted = deleted;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_desc=" + account_desc + ", reporting_manager="
				+ reporting_manager + ", deleted=" + deleted + ", createdOn=" + createdOn + ", createdBy=" + createdBy
				+ ", modifiedOn=" + modifiedOn + ", modifiedBy=" + modifiedBy + "]";
	}

	
		        
	

}
