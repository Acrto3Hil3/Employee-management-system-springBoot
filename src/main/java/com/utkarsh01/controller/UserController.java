package com.utkarsh01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.utkarsh01.entity.OwnUser;
import com.utkarsh01.repository.OwnUserRepository;

@Controller
public class UserController {
	
	@Autowired
	private OwnUserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/users")
	public String userDisplay(Model model) {
		model.addAttribute("userKey", repository.findAll());
		return "userPage";
	}
	
	@GetMapping("/addUser")
	public String signUp(Model model) {
	    model.addAttribute("ownUser", new OwnUser());
	    return "addUserPage";
	}

	@PostMapping("/saveUser")
	public String register(@ModelAttribute OwnUser ownUser, Model model) {
	    ownUser.setPassword(encoder.encode(ownUser.getPassword()));
	    repository.save(ownUser);

	    // Add success message to the model
	    model.addAttribute("successMessage", "Registration completed successfully! Redirecting to the Home page shortly.");
	    
	    // Prepare an empty form for redisplay
	    model.addAttribute("ownUser", new OwnUser());
	    return "addUserPage";
	}


}
