package com.m3support.demo.service;

import java.util.List;

import com.m3support.demo.entity.Account;

public interface AccountService {

	
	//Method that allows an administrator to add an account.
	void createAccount(Account account);
	
	//Method to retrieve all accounts.
	List<Account> getAllAccounts();
	
	
}
