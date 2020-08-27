package com.m3support.demo.service;

import java.sql.Date;
import java.util.List;

import com.m3support.demo.entity.Report;

public interface ReportService {
	
	//Method to retrieve all employees submitted reports.
	List<Report> getAllDSRReports();	
		
	//Method to retrieve an employees submitted reports by their employee psid.
	List<Report> getDSROfSpecificEmployee(int emp_psid);
	
	//Method to retrieve an employees submitted reports by their employee psid and specific range.
	List<Report> getDSROfSpecificEmployeeByDateRange(int emp_psid,Date startDate,Date endDate);
	
	//Method to retrieve all employees DSR reports under a specific project.
	List<Report> getEmploeyeeDSRUnderProjects(int project_id);
	
	//Method that allows an employee to submit their daily report.
	void createDSR(Report report);
	
	//Method that allows a manager to generate a report.
	public String generateDSRReport(Date currentDate) throws Exception;

	
	
}
