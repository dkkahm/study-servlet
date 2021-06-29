package com.example.demo4.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo4.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Override
	public String getGreeting(String name) {
		return "Hello, " + name + "!";
	}

}
