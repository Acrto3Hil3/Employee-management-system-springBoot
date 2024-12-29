package com.utkarsh01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utkarsh01.entity.Employee;
import com.utkarsh01.service.EmployeeService;

@Controller
public class SearchController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/searchByName")
	public String searchByName(@RequestParam("empName") String name,Model model) {
		model.addAttribute("empKey", service.searchEmpbyName(name));
		return "home";
	}
	
	@PostMapping("/searchByAddress")
	public String searchByAddress(@RequestParam("empAddress") String address, Model model) {
		model.addAttribute("empKey",service.searchEmpByAddress(address));
		return "home";
	}
	
	@PostMapping("/searchBySalary")
	public String searchBySalary(@RequestParam("empSalary") Double salary,Model model) {
		if(salary.intValue()==0)
			return "redirect/home";
	List<Employee> empSal=	service.searchEmpySal(salary);
	model.addAttribute("empkey",empSal);
	return "home";
	}
}
