package com.m3support.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.m3support.demo.entity.Account;
import com.m3support.demo.repositories.AccountRepository;

@Service
public class AccountServiceImplementation  implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;

	
	//Method that allows an employee to submit their daily report.
	@Override
	@PostMapping("/admin")
	public void createAccount(Account account) {
				 
		this.accountRepository.save(account);
			 
	}
		
	//Method to retrieve all employees submitted reports.
	@Override
	@GetMapping("/admin")
	public List<Account> getAllAccounts(){
			
			return accountRepository.findAll();
	}
	
}
