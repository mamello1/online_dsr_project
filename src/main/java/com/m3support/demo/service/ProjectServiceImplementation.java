package com.m3support.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3support.demo.entity.Project;
import com.m3support.demo.repositories.ProjectRepository;

@Service
public class ProjectServiceImplementation implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public List<Project> getAllProjects() {
		
		return projectRepository.findAll(); 
		
	}

	@Override
	public List<Project> getProjectsUnderAccount(int account_id) {
		
		return projectRepository.findProjectsUnderAccounts(account_id);

	}
}
