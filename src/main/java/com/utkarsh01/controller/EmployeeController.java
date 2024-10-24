package com.utkarsh01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utkarsh01.entity.Employee;
import com.utkarsh01.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("empKey",service.showAllEmp());
		return "home";
	}
	
	@GetMapping("/addEmp")
	public String addEmployee(Model model) {
		model.addAttribute(new Employee());
		return "addPage";
	}
}
