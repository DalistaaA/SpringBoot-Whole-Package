package com.online_shopping.employee.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.online_shopping.employee.entities.Employee;

public interface EmployeeRepository
    extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {

  Optional<Employee> findByEmail(String email);
}
