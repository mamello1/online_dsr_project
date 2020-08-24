

package com.m3support.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_master")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private int project_id;
	
	
	@Column(name = "project_desc")
	private String project_desc;
	

	@Column(name = "reporting_manager")
	private String reporting_manager;
	
	
	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account_master;
	
	
	//Account default constructor
	public Project() {
		
	}


	public Project(int project_id, String project_desc,String reporting_manager) {
		this.project_id = project_id;
		this.project_desc = project_desc;
		this.reporting_manager = reporting_manager;

	}


	public int getProject_id() {
		return project_id;
	}


	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}


	public String getProject_desc() {
		return project_desc;
	}


	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}

	public String getReporting_manager() {
		return reporting_manager;
	}

	public void setReporting_manager(String reporting_manager) {
		this.reporting_manager = reporting_manager;
	}
	
	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_desc=" + project_desc + ",reporting_manager=" + reporting_manager + "]";
	}
	
	
}

