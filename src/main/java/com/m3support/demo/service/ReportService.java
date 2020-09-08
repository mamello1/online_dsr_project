package com.m3support.demo.service;

import java.sql.Date;
import java.util.List;

import com.m3support.demo.entity.Report;

public interface ReportService {
	
	List<Report> getAllDSRReports();	
		
	List<Report> getDSROfSpecificEmployee(int emp_id);
	
	List<Report> getDSROfSpecificEmployeeByDateRange(int emp_id,Date startDate,Date endDate);
	
	List<Report> getEmployeeDSRUnderProjects(int project_id);
	
	public String createDSR(Report report);
	
	public String generateDSRReport(Date currentDate) throws Exception;

	
	
}
