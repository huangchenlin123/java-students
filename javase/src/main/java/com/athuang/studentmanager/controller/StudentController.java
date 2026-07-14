package com.athuang.studentmanager.controller;

import com.athuang.studentmanager.Student;
import com.athuang.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 1. 查询所有学生
     */
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    /**
     * 2. 根据ID查询学生
     */
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.findById(id);
    }

    /**
     * 3. 添加学生
     */
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "添加成功！ID=" + student.getId();  // 返回自增ID
    }

    /**
     * 4. 修改学生信息
     */
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        boolean updated = studentService.updateStudent(id, student);
        return updated ? "修改成功！" : "学生不存在！";
    }

    /**
     * 5. 删除学生
     */
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        boolean deleted = studentService.deleteById(id);
        return deleted ? "删除成功！" : "学生不存在！";
    }
}