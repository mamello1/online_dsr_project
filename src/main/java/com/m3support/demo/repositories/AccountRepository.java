package com.m3support.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m3support.demo.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

}
