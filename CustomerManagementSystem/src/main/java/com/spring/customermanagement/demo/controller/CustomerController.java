package com.spring.customermanagement.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.customermanagement.demo.model.Customer;
import com.spring.customermanagement.demo.service.CustomerService;

@Controller
public class CustomerController {
	
	public CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer";
	}

	@GetMapping("/customer")
	public ModelAndView customer() {
		List<Customer> customers = customerService.listOfCustomers();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customer", customers); //may be an error
		modelAndView.setViewName("customer");
		return modelAndView;
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer";
	}

	
}
