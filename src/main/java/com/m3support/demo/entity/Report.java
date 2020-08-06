package com.m3support.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "report_transactional")
public class Report {
	
		
	@Column(name = "task_completed")
	private String taskCompleted;
	
	@Column(name = "task_planned")
	private String taskPlanned;
	
	@Column(name = "task_issue")
	private String taskIssue;
	
	@Column(name = "submission_date")
	private Date submissionDate;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	 
	@ManyToOne
	@JoinColumn(name = "emp_psid")
	private Employee employee;
	
	
	public Report() {
		
	}
	
	public Report(String taskCompleted,String taskPlanned,String taskIssue,Date submissionDate) {
		
		this.taskCompleted = taskCompleted;
		this.taskPlanned = taskPlanned;
		this.taskIssue  = taskIssue;
		this.submissionDate = submissionDate;
	}
	
				
		//Set method for employee firstname.
		public void setTaskCompleted(String taskCompleted) {
						
				this.taskCompleted= taskCompleted;		
			}
								
		//Get method for employee firstname.
		public String getTaskCompleted() {
						
				return taskCompleted;		
			}
								
		//Set method for employee username.
		public void setTaskPlanned(String taskPlanned) {
					
				this.taskPlanned = taskPlanned;		
			}
						
		//Get method for  employee username.
		public String getTaskPlanned() {
					
			return taskPlanned;
			
			}
		
		//Set method for project description.
			public void setTaskIssue(String taskIssue) {
						
					this.taskIssue = taskIssue;		
				}
							
			//Get method for project description.
			public String getTaskIssue() {
						
				return taskIssue;
				
				}
				
			

			//Set method for project description.
			public void setSubmissionDate(Date submissionDate) {
							
						this.submissionDate = submissionDate;		
					}
								
				//Get method for project description.
				public Date getSubmissionDate() {
							
					return submissionDate;
					
					}
			
			@Override
			public String toString() {
				
			return "Reports{" +
			                
		                ", Task Completed = '" + taskCompleted + '\'' +
		                
		                ", Task Planned ='" + taskPlanned + '\'' + 
		                
		                 ", Task Issue ='" + taskIssue + '\'' + 
		                 
		                  ", Submission Date  ='" + submissionDate + '\'' + 
		                                
		                '}';
				
			}

		
		


}
