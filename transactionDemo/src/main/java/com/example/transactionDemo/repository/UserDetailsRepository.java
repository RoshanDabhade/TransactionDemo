package com.example.transactionDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transactionDemo.entity.User;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {

	User findByUserId(String user);

}
