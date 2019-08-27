
package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
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

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

/**
 * 
 * @author zama
 *
 */
@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	private Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());


	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@GetMapping("/backfill")
	public String backfill() {
		LOGGER.info("Loading sample employees");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("john", "st"));
		employees.add(new Employee("mark","jones"));
		employees.add(new Employee("rick","syder"));
		employees.add(new Employee("paul","john"));
		
		for (Employee employee : employees) {
			employeeRepository.save(employee);
		}
		return "Added sample employees!!!";
	}
	
	@GetMapping("/test")
	public String test() {
		LOGGER.info("get all employees");
		return "REST API test success!";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public List<Employee> get() {
		LOGGER.info("/all");
		return employeeRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Employee create(@Valid @RequestBody Employee employee) {
		LOGGER.info("/create : "+employee);
		return employeeRepository.save(employee);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/create-random")
	public Employee createRandom() {
		Employee employee = new Employee(RandomStringUtils.random(5, true, false),
				RandomStringUtils.random(5, true, false));
		LOGGER.info("/create-random : "+employee);
		return employeeRepository.save(employee);
	}
	
	@PostMapping("/update")
	public Employee update(@Valid @RequestBody Employee employeeUpdate) {
		Employee employeeFind = employeeRepository.findById(employeeUpdate.getId()).get();
		employeeFind.setFirstName(employeeUpdate.getFirstName());
		employeeFind.setLastName(employeeUpdate.getLastName());
		return employeeRepository.save(employeeFind);
	}
	
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable(value = "id") Long employeeId) {
		 employeeRepository.deleteById(employeeId);
	}

	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> findById(@PathVariable(value = "id") Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		if(employee == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(employee);
	}
}
