package com.utkarsh01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utkarsh01.service.EmployeeService;

@Controller
public class LoginController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/login")
	public String login() {
		return "index";
	}

	
}
