package com.m3support.demo.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.m3support.demo.entity.Report;
import com.m3support.demo.entity.ReportId;

@Repository
public interface ReportRepository extends JpaRepository<Report,ReportId>{

	@Query("SELECT rep FROM Report rep WHERE rep.emp_psid.emp_psid =?1")
	List<Report> getDSROfSpecificEmployee(int emp_psid);
	
	@Query("SELECT rep FROM Report rep WHERE rep.emp_psid.emp_psid =?1 AND rep.submission_date.submission_date BETWEEN ?2 and ?3 ")
	List<Report> getDSROfSpecificEmployeeByDateRange(int emp_psid,Date startDate,Date endDate);
	
	@Query("SELECT rep FROM Report rep WHERE rep.submission_date =?1")
	List<Report> generateDSRReport(Date currentDate);
	
	@Query("SELECT rep from Report rep where rep.project_id.project_id = ?1 ")
	List<Report> getEmployeesDSRUnderProjects(int project_id);

	
	
}
