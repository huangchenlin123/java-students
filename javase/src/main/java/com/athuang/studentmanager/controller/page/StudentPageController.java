package com.athuang.studentmanager.controller.page;

import com.athuang.studentmanager.Student;
import com.athuang.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Thymeleaf 页面控制器 — 学生管理页面跳转
 */
@Controller
@RequestMapping("/students/page")
public class StudentPageController {

    @Autowired
    private StudentService studentService;

    /**
     * 学生列表页
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    /**
     * 添加学生表单页
     */
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student(null, "", 0, ""));
        model.addAttribute("isEdit", false);
        return "student/form";
    }

    /**
     * 编辑学生表单页
     */
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Student student = studentService.findById(id);
        if (student == null) {
            return "redirect:/students/page";
        }
        model.addAttribute("student", student);
        model.addAttribute("isEdit", true);
        return "student/form";
    }

    /**
     * 保存学生（新增或更新）
     */
    @PostMapping("/save")
    public String save(Student student, RedirectAttributes redirectAttributes) {
        if (student.getId() == null) {
            // 新增 - id 由数据库自增
            studentService.addStudent(student);
            redirectAttributes.addFlashAttribute("message", "添加成功！");
        } else {
            // 修改
            studentService.updateStudent(student.getId(), student);
            redirectAttributes.addFlashAttribute("message", "修改成功！");
        }
        return "redirect:/students/page";
    }

    /**
     * 删除学生
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        boolean deleted = studentService.deleteById(id);
        redirectAttributes.addFlashAttribute("message",
                deleted ? "删除成功！" : "学生不存在！");
        return "redirect:/students/page";
    }
}
