package com.BankingApp.service;

import java.util.List;

import com.BankingApp.dto.AccountDTO;
import com.BankingApp.entity.Account;

public interface AcctService {
	
	abstract AccountDTO createAcct(AccountDTO acct);
	
	abstract AccountDTO getAcctById(Long id);
	
	abstract AccountDTO deposit(Long id,double amount);
	
	abstract AccountDTO withdraw(Long id,double amount);
	
	abstract List<AccountDTO> getAllAccts();
	
	abstract void deleteAcct(Long id);
}
