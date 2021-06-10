package com.example.transactionDemo.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transactionDemo.entity.AccountDetails;
import com.example.transactionDemo.entity.FundTransfer;
import com.example.transactionDemo.entity.TransactionDetails;
import com.example.transactionDemo.repository.AccountDetailsRepository;
import com.example.transactionDemo.repository.TransactionDetailsRepository;

@Service
@Transactional
public class TransactionServices {

	@Autowired
	private TransactionDetailsRepository transactionDetailsRepository;
	
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	public TransactionDetails fundTransfer(FundTransfer fundTransfer) {
		
		AccountDetails accountDetailsForFromAccount = accountDetailsRepository.findByAccountNo(fundTransfer.getFromAccount());
		AccountDetails accountDetailsForToAccount = accountDetailsRepository.findByAccountNo(fundTransfer.getToAccount());
		
		Double fromAccountsubstract = (accountDetailsForFromAccount.getAvailableBalance()-fundTransfer.getAmount());
		accountDetailsForFromAccount.setAvailableBalance(fromAccountsubstract);
		accountDetailsRepository.updateFundToAccounts(fundTransfer.getFromAccount(), accountDetailsForFromAccount.getAvailableBalance());
		
		Double toAccountSum = Double.sum(accountDetailsForToAccount.getAvailableBalance(), fundTransfer.getAmount());
		accountDetailsForToAccount.setAvailableBalance(toAccountSum);
		
		accountDetailsRepository.updateFundToAccounts(fundTransfer.getToAccount(),accountDetailsForToAccount.getAvailableBalance());
		
		TransactionDetails transactionDetails = this.save(fundTransfer.getFromAccount(), fundTransfer.getAmount(), "D", new BigInteger("9087653421"));
		
		this.save(fundTransfer.getToAccount(), fundTransfer.getAmount(), "C", new BigInteger("9087653421"));
		
		
		return transactionDetails;
		
	}
	
	public TransactionDetails save (Long accountNo , Double amount ,String flag,BigInteger reference_No)
	{
		AccountDetails accountDetails = accountDetailsRepository.findByAccountNo(accountNo);
		
		TransactionDetails transactionDetails = new TransactionDetails();
		
		transactionDetails.setTransactionAmount(amount);
		transactionDetails.setTransactionFlag(flag);
		transactionDetails.setReferenceNumber(reference_No);
		
		transactionDetails.setAccountDetails(accountDetails);
		accountDetails.getTransactionDetails().add(transactionDetails);
		//transactionDetails.setAccountNo(accountDetails.getAccountNo());
		
		return transactionDetailsRepository.save(transactionDetails);
	}
	
	public  List<TransactionDetails> getTransactionDetails(String sAccountNo) {
		Long sAccountNoInLong = Long.parseLong(sAccountNo);
		return transactionDetailsRepository.findByAccountNo(sAccountNoInLong);
	}
}
