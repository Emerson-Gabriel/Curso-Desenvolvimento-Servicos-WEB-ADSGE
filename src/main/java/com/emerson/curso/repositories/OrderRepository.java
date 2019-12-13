package com.emerson.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emerson.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
