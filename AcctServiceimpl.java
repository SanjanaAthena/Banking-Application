package com.BankingApp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingApp.dto.AccountDTO;
import com.BankingApp.entity.Account;
import com.BankingApp.mapper.AcctMapper;
import com.BankingApp.repository.AcctRepo;
import com.BankingApp.service.AcctService;

@Service
public class AcctServiceimpl implements AcctService {
	//@Autowired
	private AcctRepo acctrepo;
	
	public AcctServiceimpl(AcctRepo acctrepo) {
		super();
		this.acctrepo = acctrepo;
	}

	@Override
	public AccountDTO createAcct(AccountDTO acctDto)
	{
		Account acct=AcctMapper.mapToAcct(acctDto);
		Account savedAcct= acctrepo.save(acct);
		return AcctMapper.mapToAcctDto(savedAcct);
	}

	@Override
	public AccountDTO getAcctById(Long id) {
		Account acct= acctrepo.findById(id).orElseThrow((()-> new RuntimeException("Acct does not exsist")));
		
		return AcctMapper.mapToAcctDto(acct);
	}

	@Override
	public AccountDTO deposit(Long id, double amount) {
		Account acct= acctrepo.findById(id).orElseThrow((()-> new RuntimeException("Acct does not exsist")));
		double totalBalance= acct.getBalance()+ amount;
		acct.setBalance(totalBalance);
		Account savedAcct= acctrepo.save(acct);
		return AcctMapper.mapToAcctDto(savedAcct);
	}

	@Override
	public AccountDTO withdraw(Long id, double amount) {
		Account acct= acctrepo.findById(id).orElseThrow((()-> new RuntimeException("Acct does not exsist")));
		if(acct.getBalance()<amount)
		{
			throw new RuntimeException("Insufficient funds ");
		}
		double totalBalance= acct.getBalance() - amount;
		acct.setBalance(totalBalance);
		Account savedAcct= acctrepo.save(acct);
		return AcctMapper.mapToAcctDto(savedAcct);
	}

//	@Override
//	public AccountDTO deleteAcct(AccountDTO acctDto) {
//		Account acct=AcctMapper.mapToAcct(acctDto);
//		Account deleteAcct= acctrepo.delete(acct);
//		return AcctMapper.mapToAcctDto(deleteAcct);
//	}

	@Override
	public List<AccountDTO> getAllAccts() {
		return acctrepo.findAll().stream().map((account)->AcctMapper.mapToAcctDto(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteAcct(Long id) {
		Account acct= acctrepo.findById(id).orElseThrow((()-> new RuntimeException("Acct does not exsist")));
		acctrepo.delete(acct);
		
	}
}
