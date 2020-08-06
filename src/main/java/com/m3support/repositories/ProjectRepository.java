package com.m3support.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m3support.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

}
