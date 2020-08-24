package com.m3support.demo.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.m3support.demo.service.ReportService;

@RestController
@RequestMapping("/api")
public class ManagerController {
	
	@Autowired
	ReportService reportService;
	
	 @GetMapping("/manager/{currentDate}")
	 public String generateDSRReport(@PathVariable("currentDate") Date currentDate) throws Exception{ 
		 
	    return reportService.generateDSRReport(currentDate);    	
	 }

}
