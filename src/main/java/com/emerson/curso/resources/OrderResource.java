package com.emerson.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emerson.curso.dto.OrderDTO;
import com.emerson.curso.entities.Order;
import com.emerson.curso.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
   
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
		List<OrderDTO> list= service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value ="/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
		
		OrderDTO dto= service.findById(id);
		return ResponseEntity.ok().body(dto);
		
	}
}