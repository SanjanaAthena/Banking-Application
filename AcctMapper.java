package com.BankingApp.mapper;

import com.BankingApp.dto.AccountDTO;
import com.BankingApp.entity.Account;

public class AcctMapper {

	public static Account mapToAcct(AccountDTO acctDto)
	{
		Account acct=new Account(
				acctDto.getId(),
				acctDto.getAcctHolderName(),
				acctDto.getBalance()
				);
				
				
				
		return acct;			
	}
	
	public static AccountDTO mapToAcctDto(Account acct)
	{
		AccountDTO acctDto=new AccountDTO(
				acct.getId(),
				acct.getAcctHolderName(),
				acct.getBalance()
				);
				
				
				
		return acctDto;		
	}
}
