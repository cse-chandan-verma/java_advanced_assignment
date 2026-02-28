package com.springrest.api.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_reg_no")
    private Long studentRegNo;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_email")
    private String email;

    @Column(name = "student_contact_number")
    private long contactNumber;

    public Student() {
    }

    public Student(Long studentRegNo, String name, String email, long contactNumber) {
        this.studentRegNo = studentRegNo;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public Long getStudentRegNo() {
        return studentRegNo;
    }

    public void setStudentRegNo(Long studentRegNo) {
        this.studentRegNo = studentRegNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
}