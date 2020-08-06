package com.m3support.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3support.demo.entity.Report;
import com.m3support.demo.repositories.ReportRepository;

@RestController
@RequestMapping("/api/report")
public class ReportController {
	
	@Autowired
	private ReportRepository reportRepository;
	
	
	@PostMapping("/")
	public Report createDSR(@Valid @RequestBody Report report) {
		
		return reportRepository.save(report);
		
	}
	
	//@GetMapping("/{id}")
    //public ResponseEntity<Report> viewDSRById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
       //Report report= reportRepository.findById(id)
        		
       // .orElseThrow(() -> new ResourceNotFoundException("Report not found for this employee psid :: " + employeeId));
        
        //return ResponseEntity.ok().body(report);
    //}
	

}
