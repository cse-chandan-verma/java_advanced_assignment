package com.springrest.api.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.api.demo.model.Inspection;

@Repository
public interface InspectionRepository extends JpaRepository<Inspection, Long>{

}
