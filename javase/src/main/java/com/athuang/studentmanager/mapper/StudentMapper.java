package com.athuang.studentmanager.mapper;

import com.athuang.studentmanager.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student")
    List<Student> findAll();

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(Integer id);

    @Insert("INSERT INTO student(name, age, sex) VALUES(#{name}, #{age}, #{sex})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student student);

    @Update("UPDATE student SET name = #{name}, age = #{age}, sex = #{sex} WHERE id = #{id}")
    int update(Student student);

    @Delete("DELETE FROM student WHERE id = #{id}")
    int deleteById(Integer id);
}
