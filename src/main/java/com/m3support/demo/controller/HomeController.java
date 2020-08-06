package com.m3support.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

	@Autowired
 	@PreAuthorize("hasRole('users')")
 	@RequestMapping("/")
 	public String helloUser() {
		
		return "Hello Member Of Group Users";
				
	}
		
	@Autowired
 	@PreAuthorize("hasRole('manager')")
 	@RequestMapping("/manager")
 	public String helloManager() {
		
		return "Hello Member Of Group Manager";
				
	}
}
