package br.com.compasso.interview.service;

import java.util.Optional;

import com.recrutamento.compasso.entity.Customer;

public interface CustomerService {

	Customer save(Customer customer);

	void remove(Customer customer);
	
	Optional<Customer> findById(Long id);
	
	Customer findByName(String name);

}
