package com.BankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BankingApp.entity.Account;

@Repository
public interface AcctRepo extends JpaRepository<Account,Long>{

}
