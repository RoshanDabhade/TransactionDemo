package com.example.transactionDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transactionDemo.entity.AccountDetails;
import com.example.transactionDemo.entity.TransactionDetails;


public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {

	List<TransactionDetails> findByAccountNo(Long accountNo);


}
