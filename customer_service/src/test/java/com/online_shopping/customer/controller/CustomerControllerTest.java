package com.online_shopping.customer.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.online_shopping.customer.entities.Customer;
import com.online_shopping.customer.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private CustomerService customerService;
	
	@Test
	final void testCreateCustomer() {
		Customer customer = new Customer();
//		customer.setName("Dalistaa");
//		customer.setPhoneNumber("0770653784");
//		customer.setGender("Female");
//		customer.setEmail("adalistaa@gmail.com");
//		customer.setAddress("Mayiliddy");
//		given(customerService.createCustomer(customer));
	}

	@Test
	final void testUpdateCustomer() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetAllCustomers() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetCustomerByIdLong() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetCustomerByIdString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testDeleteCustomerById() {
		fail("Not yet implemented"); // TODO
	}

}
