package com.utkarsh01.repository;

import java.util.Optional;

import com.utkarsh01.entity.OwnUser;

public interface OwnUserRepository {
	// username is email
	Optional<OwnUser> findByEmail(String email);
	
}
