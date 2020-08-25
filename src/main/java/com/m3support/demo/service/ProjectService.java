package com.m3support.demo.service;

import java.util.List;

import com.m3support.demo.entity.Project;


public interface ProjectService {
	
	//Method to retrieve all projects.
	List<Project> getAllProjects();
	
	//Method to retrieve all projects under a specific account.
	List<Project> getProjectsUnderAccount(int account_id);



}
