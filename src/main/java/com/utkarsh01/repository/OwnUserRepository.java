package com.utkarsh01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarsh01.entity.OwnUser;

public interface OwnUserRepository extends JpaRepository<OwnUser, Integer> {
	
	// username is email
	Optional<OwnUser> findByEmail(String email);
	
	
}
