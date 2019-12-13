package com.emerson.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emerson.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
