package com.example.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo4.service.GreetingService;

@Controller
public class HelloController {
	private GreetingService greetingService;

	@ResponseBody
	@RequestMapping("/")
	public String helloWorld() {
		return "Hello, World!";
	}

	@ResponseBody
	@RequestMapping("/custom")
	public String helloName(@RequestParam("name") String name) {
		return this.greetingService.getGreeting(name);
	}

	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
}