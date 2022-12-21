package com.online_shopping.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.online_shopping.employee.entities.Employee;
import com.online_shopping.employee.service.EmployeeService;
import com.online_shopping.employee.serviceImpl.RestEndpoints;

@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  public String vieHomePage(Model model) {
    return findPaginated(1, model);
    // model.addAttribute("listEmployees", employeeService.getAllEmployee());
    // return "index";
  }

  @GetMapping("/showNewEmployeeForm")
  public String showNewEmployeeForm(Model model) {
    Employee employee = new Employee();
    model.addAttribute("employee", employee);
    return "new_employee";
  }

  @PostMapping("/saveEmployee")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    employeeService.createEmployee(employee);
    return "redirect:/";
  }


  @GetMapping("/showFormForUpdate/{id}")
  public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
    Employee employee = employeeService.getById(id);
    model.addAttribute("employee", employee);
    return "update_employee";
  }

  @GetMapping("/deleteEmployee/{id}")
  public String deleteEmployee(@PathVariable(value = "id") long id) {
    // call delete employee method
    this.employeeService.deleteEmployeeById(id);
    return "redirect:/";
  }

  @GetMapping("/page/{pageNo}")
  public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
    int pageSize = 5;
    Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
    List<Employee> listEmployees = page.getContent();

    model.addAttribute("currentPage", pageNo);
    model.addAttribute("totalPages", page.getTotalPages());
    model.addAttribute("totalItems", page.getTotalElements());
    model.addAttribute("listEmployees", listEmployees);
    return "index";
  }


  // ***********************************

  @PostMapping(value = RestEndpoints.EMPLOYEE_POST_API)
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    return ResponseEntity.ok(employeeService.createEmployee(employee));
  }

  @PutMapping(value = RestEndpoints.EMPLOYEE_UPDATE_API)
  public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
      @RequestBody Employee employee) {
    return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
  }

  @GetMapping(value = RestEndpoints.EMPLOYEE_GET_ALL_API)
  public ResponseEntity<List<Employee>> getAllEmployees() {
    return ResponseEntity.ok(employeeService.getAllEmployee());
  }

  @GetMapping(value = RestEndpoints.EMPLOYEE_GET_BY_ID_API)
  public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
    return ResponseEntity.ok(employeeService.getById(id));
  }

  @GetMapping(value = RestEndpoints.EMPLOYEE_GET_BY_EMAIL_API)
  public ResponseEntity<Employee> getCustomerById(@RequestParam(value = "email") String email) {
    return ResponseEntity.ok(employeeService.getByEmail(email));
  }

  @DeleteMapping(value = RestEndpoints.EMPLOYEE_DELETE_API)
  public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
    employeeService.deleteEmployeeById(id);
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
