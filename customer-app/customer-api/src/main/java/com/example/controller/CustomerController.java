
package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.repository.CustomeRepository;

/**
 * 
 * @author zama
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	private Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

	@Autowired
	CustomeRepository customerRepository;

	@GetMapping("/test")
	public String test() {
		LOGGER.info("get all customers");
		return "REST API test success!";
	}

	@GetMapping("/backfill")
	public String backfill() {
		LOGGER.info("Adding mock customers");

		List<Customer> list = new ArrayList<Customer>();	
		for (int i=0; i<5; i++) {
			list.add(new Customer("first"+i, "last"+i));
		}
		customerRepository.saveAll(list);

		return "Added mock customers ...";
	}

	@GetMapping("/all")
	public List<Customer> get() {
		LOGGER.info("get all customers");
		return customerRepository.findAll();
	}

	@PostMapping("/create")
	public Customer create(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PostMapping("/update")
	public Customer update(@Valid @RequestBody Customer customerUpdate) {
		Customer customerFind = customerRepository.findById(customerUpdate.getId()).get();
		customerFind.setFirstName(customerUpdate.getFirstName());
		customerFind.setLastName(customerUpdate.getLastName());
		return customerRepository.save(customerFind);
	}

	@PostMapping("/delete/{id}")
	public void delete(@PathVariable(value = "id") Long customerId) {
		customerRepository.deleteById(customerId);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Customer> findById(@PathVariable(value = "id") Long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(customer.get());
	}

}
