package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
        return studentCourseRepository.findAllWithStudentsAndCourses();
    }

    public Optional<Student> findStudentWithHighestGpa() {
        return studentRepository.findAll()
                .stream()
                .max(Comparator.comparingDouble(Student::getGpa)); // Use Stream API for better readability & performance
    }

    public String joinStudentNames() {
        return studentRepository.findAll()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(", ")); // More efficient string concatenation
    }
}

