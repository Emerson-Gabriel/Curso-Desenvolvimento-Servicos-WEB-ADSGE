package com.emerson.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emerson.curso.entities.Category;
import com.emerson.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
