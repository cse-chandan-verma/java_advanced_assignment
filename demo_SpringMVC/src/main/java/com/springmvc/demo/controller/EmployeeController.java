package com.springmvc.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.demo.model.Employee;
import com.springmvc.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	public EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public String getEmployeeDetails(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employees";
	}
	
	@GetMapping("/enployees")
	public ModelAndView getEmployeesDetails() {
		List<Employee>employees = employeeService.getAllEmployees();
		ModelAndView mv = new ModelAndView();
		mv.addObject("employees", employees);
		mv.setViewName("employee");
		return mv;
	}
	
	@GetMapping("/addEmployee")
	public String showAddForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@GetMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";	
	}
	
	
}
