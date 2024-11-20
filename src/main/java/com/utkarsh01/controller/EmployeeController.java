package com.utkarsh01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.utkarsh01.entity.Employee;
import com.utkarsh01.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private PasswordEncoder encoder;

	@GetMapping(value = {"/","/home"})
	public String main(Model model) {
		model.addAttribute("empKey", service.showAllEmp());
		return "home";
	}

	@GetMapping("/addEmp")
	public String addEmployee(Model model) {
		model.addAttribute(new Employee());
		return "addEmpPage";
	}

	@PostMapping("/saveEmp")
	public String saveEmployee(@Validated Employee emp, BindingResult rs) {
		if (rs.hasErrors())
			return "addEmpPage";
		service.inserEmp(emp);
		return "redirect:/home";
	}

	@GetMapping("/editEmp/{id}")
	public String editEmployee(@PathVariable("id") Integer id, Model model) {
		Employee emp = service.showOneEmp(id);
		model.addAttribute(emp);
		return "editEmpPage";
	}

	@PostMapping("/updateEmp")
	public String updateEmployee(@Validated Employee emp) {
		service.updateEmp(emp);
		return "redirect:/home";
	}

	@GetMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		service.deleteEmp(id);
		return "redirect:/home";
	}
}
