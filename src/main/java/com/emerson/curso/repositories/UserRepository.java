package com.emerson.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emerson.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByEmail(String email);
}
