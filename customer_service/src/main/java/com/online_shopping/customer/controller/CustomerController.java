package com.online_shopping.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online_shopping.customer.entities.Customer;
import com.online_shopping.customer.service.CustomerService;
import com.online_shopping.customer.serviceImpl.RestEndpoints;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = RestEndpoints.CUSTOMER_POST_API)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		return ResponseEntity.ok(customerService.createCustomer(customer));
	}
	
	@PutMapping(value = RestEndpoints.CUSTOMER_UPDATE_API)
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
		return ResponseEntity.ok(customerService.updateCustomer(id,customer));
	}
	
	@GetMapping(value = RestEndpoints.CUSTOMER_GET_ALL_API)
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@GetMapping(value = RestEndpoints.CUSTOMER_GET_BY_ID_API)
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
		return ResponseEntity.ok(customerService.getById(id));
	}
	
	@GetMapping(value = RestEndpoints.CUSTOMER_GET_BY_EMAIL_API)
	public ResponseEntity<Customer> getCustomerById(@RequestParam(value="email") String email){
		return ResponseEntity.ok(customerService.getByEmail(email));
	}
	
	@DeleteMapping(value = RestEndpoints.CUSTOMER_DELETE_API)
	public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id){
		customerService.deleteCustomerById(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	
}
