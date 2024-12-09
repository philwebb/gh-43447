package com.example.errorCheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.errorCheck.service.TestService1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService1 testService1;

	@GetMapping
	public Integer handleGetRequest(HttpServletRequest request, HttpServletResponse response) {
		return this.testService1.addPayment(1L);
	}

}
