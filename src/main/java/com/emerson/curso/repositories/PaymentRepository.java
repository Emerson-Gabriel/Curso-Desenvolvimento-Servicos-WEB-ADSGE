package com.emerson.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emerson.curso.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
