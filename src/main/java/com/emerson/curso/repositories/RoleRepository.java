package com.emerson.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emerson.curso.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
