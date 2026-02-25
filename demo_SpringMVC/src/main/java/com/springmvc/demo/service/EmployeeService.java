package com.springmvc.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.springmvc.demo.model.Employee;
import com.springmvc.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	public EmployeeRepository empRepository;
	
	public EmployeeService(EmployeeRepository empRepository) {
		this.empRepository = empRepository;
	}
	
	public List<Employee> getAllEmployees(){
		return empRepository.findAll();
	}

	public void saveEmployee(Employee employee) {
		empRepository.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		empRepository.deleteById(id);
	}
}


