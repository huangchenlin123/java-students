package com.athuang.studentmanager.service;

import com.athuang.studentmanager.Student;
import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Integer id);
    void addStudent(Student student);
    boolean updateStudent(Integer id, Student student);
    boolean deleteById(Integer id);
}