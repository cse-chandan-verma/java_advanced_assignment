package com.springrest.api.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.springrest.api.demo.model.Student;
import com.springrest.api.demo.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> showStudents() {
        return studentRepository.findAll();
    }

    public Student findByRegNo(Long regNo) {
        return studentRepository.findById(regNo).orElseThrow(() -> new RuntimeException("Student not found!!!"));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long regNo) {
        studentRepository.deleteById(regNo);
    }
}