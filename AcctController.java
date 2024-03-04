package com.BankingApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankingApp.dto.AccountDTO;
import com.BankingApp.service.AcctService;

@RestController
@RequestMapping("/api/accounts")
public class AcctController {

	public AcctController(AcctService acctService) {
		super();
		this.acctService = acctService;
	}
	private AcctService acctService;
	//add acct rest api
	@PostMapping
	public ResponseEntity<AccountDTO> addAcct(@RequestBody AccountDTO acctDto)
	{
	System.out.println(acctDto);
	return new ResponseEntity<>(acctService.createAcct(acctDto),HttpStatus.CREATED);
}
	//Get account by Id
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> getAcctById(@PathVariable Long id)
	{
	//System.out.println(acctDto);
		AccountDTO acctDto=acctService.getAcctById(id);
	return ResponseEntity.ok(acctDto);
}
	//to deposit 
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request)
	{
		Double amount=request.get("amount");
		AccountDTO acctDto= acctService.deposit(id,amount);
		return ResponseEntity.ok(acctDto);
				
	}
	//To withdraw
	@PostMapping("/{id}/withdraw")
	public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request)
	{
		Double amount=request.get("amount");
		AccountDTO acctDto= acctService.withdraw(id,amount);
		return ResponseEntity.ok(acctDto);
				
	}
	//Get all the accounts
	@GetMapping
	public ResponseEntity<List<AccountDTO>>getAllAccts(){
		List<AccountDTO> acctdto=acctService.getAllAccts();
		return ResponseEntity.ok(acctdto);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteAcct(@PathVariable Long id)
	{
		acctService.deleteAcct(id);
		return ResponseEntity.ok("Account deleted");
	}
}
