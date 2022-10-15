package com.abc_telecom_Ltd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc_telecom_Ltd.entity.Customer;
import com.abc_telecom_Ltd.entity.Engineer;
import com.abc_telecom_Ltd.entity.Manager;
import com.abc_telecom_Ltd.exceptions.EngineerNotPresentException;
import com.abc_telecom_Ltd.service.CustomerService;
import com.abc_telecom_Ltd.service.EngineerService;
import com.abc_telecom_Ltd.service.ManagerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ManagerService managerService;

	@Autowired
	private EngineerService engineerService;
	

	// ADD CUSTOMER
	
	@PostMapping("/addCutomer")
	public ResponseEntity<Customer> addCutomer(@RequestBody Customer cutomer) {
		Customer cutomer2 = customerService.addCutomer(cutomer);
		// ticket=null, while adding customer, after customer raised the complaint:
		// provide a ticket
		return new ResponseEntity<Customer>(cutomer2, HttpStatus.OK);
	}

	//GET CUSTOMERS
	@GetMapping("/viewCustomers")
	public ResponseEntity<List<Customer>> viewCustomers() throws Exception {
		List<Customer> customers = customerService.viewCustomers();
		if (customers.isEmpty()) {
			throw new EngineerNotPresentException();
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	// DELETE CUSTOMER
	
	@DeleteMapping("/deleteCutomer/{id}")
	public ResponseEntity<String> deleteCutomer(@PathVariable Long id) {
		customerService.deleteCutomer(id);
		return new ResponseEntity<String>("Customer deleted", HttpStatus.OK);
	}

	// ADD MANAGER
	
	@PostMapping("/addManager")
	public ResponseEntity<Manager> addManager(@RequestBody Manager manager) {
		Manager manager2 = managerService.addManager(manager);
		return new ResponseEntity<Manager>(manager2, HttpStatus.OK);
	}
	
	//GET MANAGERS
	@GetMapping("/viewManagers")
	public ResponseEntity<List<Manager>> viewManagers() throws Exception {
		List<Manager> managers = managerService.viewManagers();
		if (managers.isEmpty()) {
			throw new EngineerNotPresentException();
		}
		return new ResponseEntity<List<Manager>>(managers, HttpStatus.OK);
	}

	// DELETE MANAGER
	
	@DeleteMapping("/deleteManager/{id}")
	public ResponseEntity<String> deleteManager(@PathVariable Long id) {
		managerService.deleteManager(id);
		return new ResponseEntity<String>("Manager deleted", HttpStatus.OK);
	}

	// ADD ENGINEER
	
	@PostMapping("/addEngineer")
	public ResponseEntity<Engineer> addEngineer(@RequestBody Engineer engineer) {
		Engineer engineer2 = engineerService.addEngineer(engineer);
		return new ResponseEntity<Engineer>(engineer2, HttpStatus.OK);
	}
	
	//GET ENGINEERS
	@GetMapping("/viewEngineers")
	public ResponseEntity<List<Engineer>> viewEngineers() throws Exception {

		List<Engineer> engineers = engineerService.viewEngineersForAdmin();
		if (engineers.isEmpty()) {
			throw new EngineerNotPresentException();
		}
		return new ResponseEntity<List<Engineer>>(engineers, HttpStatus.OK);
	}

	// DELETE ENGINEER
	
	@DeleteMapping("/deleteEngineer/{id}")
	public ResponseEntity<String> deleteEngineer(@PathVariable Long id) {
		System.err.println("Delete engineer called.");
		engineerService.deleteEngineer(id);
		return new ResponseEntity<String>("Engineer deleted", HttpStatus.OK);
	}

}
