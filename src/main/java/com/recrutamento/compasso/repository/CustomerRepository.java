package com.recrutamento.compasso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recrutamento.compasso.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findById(Long id);
	
	Customer findByName(String name);
}
