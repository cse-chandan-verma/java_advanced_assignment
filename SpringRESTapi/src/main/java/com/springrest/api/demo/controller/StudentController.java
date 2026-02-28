package com.springrest.api.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.springrest.api.demo.model.Student;
import com.springrest.api.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> showStudents() {
        return studentService.showStudents();
    }

    @GetMapping("/{regNo}")
    public Student findStudentByRegNo(@PathVariable Long regNo) {
        return studentService.findByRegNo(regNo);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{regNo}")
    public void deleteStudent(@PathVariable Long regNo) {
        studentService.deleteStudent(regNo);
    }
}