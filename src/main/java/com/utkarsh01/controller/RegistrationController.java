package com.utkarsh01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.utkarsh01.entity.Employee;
import com.utkarsh01.entity.OwnUser;
import com.utkarsh01.repository.OwnUserRepository;

@Controller
public class RegistrationController {
	
	@Autowired
	private OwnUserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/signUp")
	public String signUp(OwnUser ownUser ,Model model) {
		model.addAttribute(ownUser);
		return "registrationPage";
	}
	
	
	@PostMapping("/register")
	public String register(@ModelAttribute OwnUser ownUser) {
		ownUser.setPassword(encoder.encode(ownUser.getPassword()));
		repository.save(ownUser);
		return "successPage";
	}
}
