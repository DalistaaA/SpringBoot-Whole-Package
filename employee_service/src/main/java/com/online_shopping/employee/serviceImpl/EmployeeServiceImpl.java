package com.online_shopping.employee.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.online_shopping.employee.entities.Employee;
import com.online_shopping.employee.repositories.EmployeeRepository;
import com.online_shopping.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public List<Employee> getAllEmployee() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee getById(Long id) {
    Optional<Employee> employee = employeeRepository.findById(id);
    if (!(employee.isPresent())) {
      throw new RuntimeException(id + "is not exists");
    }
    return employee.get();
  }

  @Override
  public Employee getByEmail(String email) {
    Optional<Employee> employee = employeeRepository.findByEmail(email);
    if (!(employee.isPresent())) {
      System.out.println(email + "is not exists");
    }
    return employee.get();
  }

  @Override
  public Employee updateEmployee(Long id, Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public void deleteEmployeeById(Long id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public Page<Employee> findPaginated(int pageNo, int pageSize) {
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
    return employeeRepository.findAll(pageable);
  }

}
