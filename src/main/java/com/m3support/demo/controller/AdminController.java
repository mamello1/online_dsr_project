package com.m3support.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3support.demo.entity.Account;
import com.m3support.demo.service.AccountService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	AccountService accountService;
	
	//Method that allows an administrator to add a account.
	@PostMapping("/admin")
	public void createAccount(@RequestBody Account account) {
				 
		 this.accountService.createAccount(account);;
			
	}
	
	//Method to retrieve all employees submitted reports.
	@GetMapping("/admin")
	public List<Account> getAllAccounts(){
			
		return accountService.getAllAccounts();
		
	}

}
