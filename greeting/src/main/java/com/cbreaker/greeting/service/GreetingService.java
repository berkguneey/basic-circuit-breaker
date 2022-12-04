package com.cbreaker.greeting.service;

import org.springframework.stereotype.Service;

import com.cbreaker.greeting.model.Customer;

@Service
public interface GreetingService {
	
	Customer getCustomerById(Long id) throws InterruptedException;

}
