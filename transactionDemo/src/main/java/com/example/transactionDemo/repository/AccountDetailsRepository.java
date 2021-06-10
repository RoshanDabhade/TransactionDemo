package com.example.transactionDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.transactionDemo.entity.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, String> {

	@Modifying
	void updateFundToAccounts(Long accountNo, double newBalance);

	AccountDetails findByAccountNo(Long accountNo);

}
