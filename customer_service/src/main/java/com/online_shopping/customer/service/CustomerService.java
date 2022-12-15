package com.online_shopping.customer.service;

import java.util.List;

import com.online_shopping.customer.entities.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getById(Long id);
	Customer getByEmail(String email);
	Customer updateCustomer(Long id, Customer customer);
	void deleteCustomerById(Long id);
	
}
