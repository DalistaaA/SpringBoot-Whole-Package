package com.online_shopping.employee.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.online_shopping.employee.entities.Employee;

public interface EmployeeService {

  Employee createEmployee(Employee employee);

  List<Employee> getAllEmployee();

  Employee getById(Long id);

  Employee getByEmail(String email);

  Employee updateEmployee(Long id, Employee employee);

  void deleteEmployeeById(Long id);

  Page<Employee> findPaginated(int pageNo, int pageSize);
}
