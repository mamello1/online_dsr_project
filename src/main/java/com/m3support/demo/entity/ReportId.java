package com.m3support.demo.entity;

import java.io.Serializable;
import java.sql.Date;


public class ReportId implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Date submission_date;
	private int project_id;
	private int emp_psid;
	
	public ReportId() {
		// TODO Auto-generated constructor stub
	}

	public ReportId(Date submission_date, int project_id, int emp_psid) {
		this.submission_date = submission_date;
		this.project_id = project_id;
		this.emp_psid = emp_psid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emp_psid;
		result = prime * result + project_id;
		result = prime * result + ((submission_date == null) ? 0 : submission_date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportId other = (ReportId) obj;
		if (emp_psid != other.emp_psid)
			return false;
		if (project_id != other.project_id)
			return false;
		if (submission_date == null) {
			if (other.submission_date != null)
				return false;
		} else if (!submission_date.equals(other.submission_date))
			return false;
		return true;
	}
	
	
	
}
