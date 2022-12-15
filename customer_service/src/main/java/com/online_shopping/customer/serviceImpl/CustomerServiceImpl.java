package com.online_shopping.customer.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_shopping.customer.entities.Customer;
import com.online_shopping.customer.repositories.CustomerRepository;
import com.online_shopping.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if(!(customer.isPresent())) {
			System.out.println(id+ "is not exists");
		}
		return customer.get();
	}

	@Override
	public Customer getByEmail(String email) {
		Optional<Customer> customer = customerRepository.findByEmail(email);
		if(!(customer.isPresent())) {
			System.out.println(email+ "is not exists");
		}
		return customer.get();
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}

}
