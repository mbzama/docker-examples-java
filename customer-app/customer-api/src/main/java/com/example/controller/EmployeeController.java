
package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class EmployeeController {
	private Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/test")
	public String test() {
		LOGGER.info("get all employees");
		return "REST API test success!";
	}

	@GetMapping("/backfill")
	public String backfill() {
		LOGGER.info("Adding mock employees");

		List<Employee> list = new ArrayList<Employee>();	
		for (int i=0; i<5; i++) {
			list.add(new Employee("first"+i, "last"+i));
		}
		employeeRepository.saveAll(list);

		return "Added mock employees ...";
	}

	@GetMapping("/all")
	public List<Employee> get() {
		LOGGER.info("get all employees");
		return employeeRepository.findAll();
	}

	@PostMapping("/create")
	public Employee create(@Valid @RequestBody Employee employee) {
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
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(employee == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(employee.get());
	}

}
