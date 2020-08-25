package com.m3support.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.m3support.demo.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
	
	@Query("SELECT proj FROM Project proj WHERE proj.account_master.account_id =?1 ")
	List<Project> findProjectsUnderAccounts(int account_id);

}
