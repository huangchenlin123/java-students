package com.athuang.studentmanager.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    // 固定账号密码（可后续改为数据库验证）
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "123456";

    /**
     * 登录页
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * 登录验证
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attr) {
        if (ADMIN_USER.equals(username) && ADMIN_PASS.equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/menu";
        }
        attr.addFlashAttribute("error", "用户名或密码错误！");
        return "redirect:/login";
    }

    /**
     * 主菜单页
     */
    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    /**
     * 退出登录
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
