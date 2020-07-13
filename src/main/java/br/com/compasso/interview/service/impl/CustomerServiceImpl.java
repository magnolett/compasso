package br.com.compasso.interview.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.recrutamento.compasso.entity.Customer;
import com.recrutamento.compasso.repository.CustomerRepository;

import br.com.compasso.interview.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	public Customer save(Customer customer) {
		return repository.saveAndFlush(customer);
	}

	public void remove(Customer customer) {
		repository.delete(customer);
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id) != null ? repository.findById(id) : null;
	}

	public Customer findByName(String name) {
		return repository.findByName(name) != null ? repository.findByName(name) : null;
	}

}
