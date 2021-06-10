package com.example.transactionDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class User {
	
	@Column(name = "user_id")
	String userId;
	
	@Id
	@Column(name="account_no")
	Long accountNo;
	
	@Column(name="password")
	String password;
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
//	private List<AccountDetails> accountDetails;
	
	public User() {
		
	}

	public User(String userId, long account_no, String password) {
		
		this.userId = userId;
		this.accountNo = account_no;
		this.password = password;
		//this.accountDetails = accountDetails;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//	public List<AccountDetails> getAccountDetails() {
//		return accountDetails;
//	}
//
//	public void setAccountDetails(List<AccountDetails> accountDetails) {
//		this.accountDetails = accountDetails;
//	}
	
	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "" + accountNo;
	}
	
	
	
	

}
