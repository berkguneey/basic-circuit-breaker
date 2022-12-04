package com.cbreaker.greeting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cbreaker.greeting.model.Customer;
import com.cbreaker.greeting.service.GreetingService;

@Service
@CacheConfig(cacheNames = { "Customer" })
public class GreetingServiceImpl implements GreetingService {

	private final static List<Customer> customerList = new ArrayList<>();

	{
		customerList.add(new Customer(1l, "Test1", "Test1", 27));
		customerList.add(new Customer(2l, "Test2", "Test2", 26));
		customerList.add(new Customer(3l, "Test3", "Test3", 25));
		customerList.add(new Customer(4l, "Test4", "Test4", 24));
	}

	@Override
	@Cacheable(key = "#id")
	public Customer getCustomerById(Long id) throws InterruptedException {
		Thread.sleep(5000);
		return customerList.stream().filter(customer -> customer.getId() == id).findFirst().orElse(null);
	}

}
