package com.m3support.demo.service;

import java.io.FileOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.m3support.demo.entity.Report;
import com.m3support.demo.repositories.ReportRepository;

@Service
public class ReportServiceImplementation implements ReportService{
	
	@Autowired
	ReportRepository reportRepository;
	
	
	//Method to retrieve all employees submitted reports.
	@Override
	public List<Report> getAllDSRReports(){
		
		return reportRepository.findAll();
	}
		
	//Method to retrieve an employees submitted reports by their psid.
	 @Override
	 public List<Report> getDSROfSpecificEmployee(@PathVariable int emp_psid){
		 
		 return reportRepository.getDSROfSpecificEmployee(emp_psid);
	 }
	 
	 
	//Method to retrieve an employees submitted reports by their psid and specific range.
	@Override
	public List<Report> getDSROfSpecificEmployeeByDateRange(@PathVariable int emp_psid,Date startDate,Date endDate){
			 
		return reportRepository.getDSROfSpecificEmployeeByDateRange(emp_psid,startDate,endDate);
		
	}
	 	 
	
	//Method that allows an employee to submit their daily report.
	@Override
	public void createDSR(Report report) {
			 
		 this.reportRepository.save(report);
		 
	}
	
	//Method that allows a manager to generate a report.
	public String generateDSRReport(Date currentDate) throws Exception {
		
		List<Report> generateDSRReport = reportRepository.generateDSRReport(currentDate);
		
		Document document = new Document(PageSize.A4);
		
		String fileLocation = "dsr_report.pdf";
		
		PdfWriter.getInstance(document, new FileOutputStream(fileLocation));
		document.open();
		document.add(new Paragraph("List of ITC Employee Daily Status Reports for : " + currentDate));
			
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
	    table.setSpacingBefore(15);
		
		addTableHeader(table);
		addRows(table, generateDSRReport); 
		document.add(table);
		
		Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler" + fileLocation);
		document.close();
		
		return "PDF File Has Successfully Been Extracted and Saved At The Following Location : " + fileLocation;
		
      }
	
	

	private void addTableHeader(PdfPTable table) 
	
	{
       Stream.of("Employee PSID","Employee Name","Task Completed For The Day", "Task Planned for Tommorow", "Difficulties/Issues Experienced")
       
      .forEach(columnTitle -> 
      
      {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);        
        header.setPhrase(new Phrase(columnTitle));
        table.addCell(header);
        
      }
      
    		  );
       
	}
	
	private void addRows(PdfPTable table, List<Report> generateDSRReport) throws Exception 
	
	{
		
	for(int i = 0 ; i < generateDSRReport.size(); i++)
		
	{
		table.addCell(Integer.toString(generateDSRReport.get(i).getEmp_psid().getEmp_psid()));
		table.addCell(generateDSRReport.get(i).getEmp_psid().getEmp_firstname());
		table.addCell(generateDSRReport.get(i).getTask_completed());
		table.addCell(generateDSRReport.get(i).getTask_planned());
		table.addCell(generateDSRReport.get(i).getTask_issues());	
	}
 
		}
	
	
	@Override
	public List<Report> getEmploeyeeDSRUnderProjects(int project_id) {
		
		return reportRepository.getEmployeesDSRUnderProjects(project_id);
			
	}

	}	

