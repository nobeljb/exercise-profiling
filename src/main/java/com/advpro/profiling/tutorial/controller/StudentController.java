package com.advpro.profiling.tutorial.controller;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.service.DataSeedService;
import com.advpro.profiling.tutorial.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author muhammad.khadafi
 */

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all-student")
    public ResponseEntity<String> seedStudents() {
        return ResponseEntity.ok(studentService.getAllStudentsWithCourses().toString());
    }

    @GetMapping("/highest-gpa")
    public ResponseEntity<String> highestGpa() {
        return ResponseEntity.ok(studentService.findStudentWithHighestGpa().get().toString());
    }

    @GetMapping("/all-student-name")
    public ResponseEntity<String> allStudentNames() {
        return ResponseEntity.ok(studentService.joinStudentNames());
    }
}

