package com.example.transactionDemo.entity;

public class FundTransfer {
	
	private Long fromAccount ;
	private Long toAccount;
	private Double amount;
	
	
	
	public FundTransfer() {
		
	}

	public FundTransfer(Long fromAccount, Long toAccount, Double amount) {
		
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}

	public Long getFromAccount() {
		return fromAccount;
	}
	
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	
	public Long getToAccount() {
		return toAccount;
	}
	
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	

}
