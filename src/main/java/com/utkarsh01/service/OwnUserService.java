package com.utkarsh01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.utkarsh01.entity.OwnUser;
import com.utkarsh01.repository.OwnUserRepository;

@Service
public class OwnUserService implements UserDetailsService {
	@Autowired
	private OwnUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<OwnUser> opt= repository.findByEmail(email);
		if(opt.isPresent())
			return opt.get();
		throw new UsernameNotFoundException("THis name User doesn't exist in database");
	}
}
