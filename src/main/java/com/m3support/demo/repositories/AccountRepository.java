package com.m3support.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.m3support.demo.dtos.AccountDto;
import com.m3support.demo.dtos.AccountIdDto;
import com.m3support.demo.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{

	@Query("SELECT new com.m3support.demo.dtos.AccountDto(a.account_id, a.account_desc, a.modifiedBy, "
			+ "a.modifiedOn, a.createdBy, a.createdOn, a.deleted,"
			+ " a.reporting_manager, COUNT(p.account_master.account_id) as projects_count) "
			+ "FROM Project p RIGHT JOIN p.account_master a "
			+ "GROUP BY a.account_id ORDER BY a.modifiedOn DESC")
    List<AccountDto> getAccountDashboard();
	
	 @Query("SELECT new com.m3support.demo.dtos.AccountIdDto(a.account_id, a.account_desc) FROM Account a")
	 List<AccountIdDto> getAccountsForProjects();

	
	
}
