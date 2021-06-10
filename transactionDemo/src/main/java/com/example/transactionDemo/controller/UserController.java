package com.example.transactionDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.transactionDemo.entity.AccountDetails;
import com.example.transactionDemo.entity.AuthRequest;
import com.example.transactionDemo.entity.FundTransfer;
import com.example.transactionDemo.entity.TransactionDetails;
import com.example.transactionDemo.service.AccountService;
import com.example.transactionDemo.service.TransactionServices;
import com.example.transactionDemo.utilities.JwtUtil;

@RestController
public class UserController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager  authenticationManager;
	
	@Autowired
	private AccountService  accountService;
	
	@Autowired
	private TransactionServices  transactionServices;
	
	@PostMapping("/userlogin")
	public  AuthRequest generateToken(@RequestBody AuthRequest authRequest) throws Exception
	{
		try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
         authRequest.setAccessToken(jwtUtil.generateToken(authRequest.getUserName()));
         return authRequest;
		
	}
	
	@GetMapping("/getBalance/{sAccountNo}")
	public AccountDetails getBalance (@PathVariable String sAccountNo) 
	{
		
		return accountService.getBalance(sAccountNo);
		
	}
	
	@PostMapping("/fundTransfer")
	public TransactionDetails fundTransfer (@RequestBody FundTransfer fundTransfer) 
	{
		
		return transactionServices.fundTransfer(fundTransfer);
		
	}
	
	@GetMapping("/getTransactionDetails/{sAccountNo}")
	public List<TransactionDetails> getTransactionDetails (@PathVariable String sAccountNo) 
	{
		
		return transactionServices.getTransactionDetails(sAccountNo);
		
	}

}
