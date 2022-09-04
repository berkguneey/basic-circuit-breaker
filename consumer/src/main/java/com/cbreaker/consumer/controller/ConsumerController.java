package com.cbreaker.consumer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/v0/consumer")
public class ConsumerController {

	private final RestTemplate restTemplate;

	public ConsumerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping
	@CircuitBreaker(name = "consumerService", fallbackMethod = "fallbackMethod")
	public ResponseEntity<String> execute() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v0/greeting",
				String.class);
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
	}

	public ResponseEntity<String> fallbackMethod(Exception e) {
		return new ResponseEntity<>("Default Response: Hello, server is down. Please try later!", HttpStatus.OK);
	}

}
