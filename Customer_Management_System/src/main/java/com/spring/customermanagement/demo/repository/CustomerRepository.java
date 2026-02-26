package com.spring.customermanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.customermanagement.demo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
