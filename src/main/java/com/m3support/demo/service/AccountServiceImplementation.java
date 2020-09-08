package com.m3support.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.m3support.demo.dtos.AccountDto;
import com.m3support.demo.dtos.AccountIdDto;
import com.m3support.demo.entity.Account;
import com.m3support.demo.repositories.AccountRepository;

@Service
public class AccountServiceImplementation  implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;

	
	//Method used to create an account.
	@Override
	public void createAccount(Account account) {
				 
		this.accountRepository.save(account);
			 
	}
	
	//Method used to update an account.
	@Override
	public void updateAccount(Account account) {
		this.accountRepository.save(account);
	}
		
	//Method to retrieve all accounts.
	@Override
	public List<Account> getAllAccounts(){
			
			return accountRepository.findAll();
	}
	
	//Method used to retrieve account dashboard details.
	@Override
	public List<AccountDto> getAccountsDashboard() {
		
		return accountRepository.getAccountDashboard();
	}
	
	//Method used to retrieve account identifier details
	@Override
	public List<AccountIdDto> getAccountsForProjects() {
		
		return accountRepository.getAccountsForProjects();
	}

}
