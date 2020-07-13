package br.com.compasso.interview.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recrutamento.compasso.dto.CustomerDto;
import com.recrutamento.compasso.entity.Customer;
import com.recrutamento.compasso.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customer) {
		
		final Customer tempCustomer = repository.findByName(customer.getNome());
		if(tempCustomer != null) {
			return new ResponseEntity<Customer>(convertToEntity(customer), HttpStatus.OK);
		} else {
			Customer saveAndFlush = repository.saveAndFlush(convertToEntity(customer));
			return new ResponseEntity<Customer>(saveAndFlush, HttpStatus.OK);
			
		}
	}
	
	@RequestMapping(value = "/customer/name", method = RequestMethod.GET)
    public ResponseEntity<Customer> findCustomerByName(@RequestParam("name") String name) {
		final Customer findByName = repository.findByName(name);
		
		if(findByName == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(findByName, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id) {
		final Optional<Customer> customer = this.repository.findById(id);
		if(customer.get() == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/remove", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeCustomer(@RequestBody CustomerDto customer) {
		repository.delete(convertToEntity(customer));
		
		return new ResponseEntity<String>("Exclusão bem sucedida!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/name", method = RequestMethod.PUT)
    public ResponseEntity<Customer> customerNameChange(@RequestParam Long id, @RequestParam String name) {
		final Customer findByName = repository.findById(id).get();
		findByName.setName(name);
		return new ResponseEntity<Customer>(repository.saveAndFlush(findByName), HttpStatus.OK);
	}
	
    private Customer convertToEntity(CustomerDto customer) {
    	return mapper.map(customer, Customer.class);
    }
}
