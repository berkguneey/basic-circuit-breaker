package com.cbreaker.greeting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/greeting")
public class GreetingContoller {

	@GetMapping
	public ResponseEntity<String> greeting(@RequestParam(value = "name", defaultValue = "World") String name)
			throws InterruptedException {
		long waitTime = (long) (Math.random() * 10000);
		System.out.println(String.format("Wait Time: %sms", waitTime));
		Thread.sleep(waitTime); // For slow call rate.
		return new ResponseEntity<>(String.format("Hello, %s!", name), HttpStatus.OK);
	}

}
