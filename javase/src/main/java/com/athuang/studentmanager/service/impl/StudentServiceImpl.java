package com.athuang.studentmanager.service.impl;

import com.athuang.studentmanager.Student;
import com.athuang.studentmanager.mapper.StudentMapper;
import com.athuang.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  // 确保所有数据库操作都在事务中执行
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public boolean updateStudent(Integer id, Student student) {
        student.setId(id);
        return studentMapper.update(student) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return studentMapper.deleteById(id) > 0;
    }
}
