package com.emerson.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emerson.curso.entities.Order;
import com.emerson.curso.entities.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByClient(User client);
}
