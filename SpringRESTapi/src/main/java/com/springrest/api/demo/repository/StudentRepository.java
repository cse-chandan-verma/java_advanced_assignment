package com.springrest.api.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springrest.api.demo.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
