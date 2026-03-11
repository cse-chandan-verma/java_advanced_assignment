package com.spring.customermanagement.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.spring.customermanagement.demo.model.Customer;
import com.spring.customermanagement.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	public CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public List<Customer> listOfCustomers() {
		return customerRepository.findAll();
	}
	
	public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
