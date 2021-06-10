package com.example.transactionDemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.transactionDemo.entity.AccountDetails;
import com.example.transactionDemo.entity.User;
import com.example.transactionDemo.repository.UserDetailsRepository;

@SpringBootApplication
public class TransactionDemoApplication {

//	@Autowired
//    private UserDetailsRepository repository;
//
//    @PostConstruct
//    public void initUsers() {
//        List<User> users = Stream.of(
//                new User("ABC12346",2345678901L, "password2", ),
//                new User("ABC12345",1234567890L, "password1"),
//                new AccountDetails()
//        ).collect(Collectors.toList());
//        repository.saveAll(users);
//    }
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionDemoApplication.class, args);
	}

}
