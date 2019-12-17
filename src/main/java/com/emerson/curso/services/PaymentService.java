package com.emerson.curso.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerson.curso.dto.PaymentDTO;
import com.emerson.curso.entities.Payment;
import com.emerson.curso.repositories.PaymentRepository;
import com.emerson.curso.services.exceptions.ResourceNotFoundException;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;

	public List<PaymentDTO> findAll(){
		List<Payment> list= repository.findAll();
		return list.stream().map(e -> new PaymentDTO(e)).collect(Collectors.toList());
	}
	public PaymentDTO findById(Long id) {

		Optional<Payment> obj= repository.findById(id);
		Payment entity= obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new PaymentDTO(entity);
	}

}