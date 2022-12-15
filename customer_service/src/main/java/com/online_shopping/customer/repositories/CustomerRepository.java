package com.online_shopping.customer.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_shopping.customer.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByEmail(String email);
}
