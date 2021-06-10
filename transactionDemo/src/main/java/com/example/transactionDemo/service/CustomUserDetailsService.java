package com.example.transactionDemo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.transactionDemo.entity.User;
import com.example.transactionDemo.repository.UserDetailsRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		User user1 =  userDetailsRepository.findByUserId(user);
		return new org.springframework.security.core.userdetails.User(user1.getUserId(), user1.getPassword(), new ArrayList<>());
	}

}
