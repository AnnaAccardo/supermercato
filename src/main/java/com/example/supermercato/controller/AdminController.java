package com.example.supermercato.controller;

import com.example.supermercato.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loginadmin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String getPage(HttpSession session, @RequestParam(name = "error", required = false) String error, Model model) {

        if(session.getAttribute("admin") != null)
            return "redirect:/adminprodotti";
        model.addAttribute("error", error);
        return "loginadmin";
    }

    @PostMapping
    public String getPost(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {

        if(!adminService.loginAdmin(username, password, session))
            return "redirect:/loginadmin?error";
        return "redirect:/adminprodotti";
    }

}