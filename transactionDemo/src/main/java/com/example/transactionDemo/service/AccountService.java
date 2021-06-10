package com.example.transactionDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transactionDemo.entity.AccountDetails;
import com.example.transactionDemo.repository.AccountDetailsRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;
	
	public AccountDetails getBalance(String sAccountNo) {
		Long sAccountNoInLong = Long.parseLong(sAccountNo);
		System.out.println(accountDetailsRepository.findByAccountNo(sAccountNoInLong));
		return accountDetailsRepository.findByAccountNo(sAccountNoInLong);
		
	}

}
