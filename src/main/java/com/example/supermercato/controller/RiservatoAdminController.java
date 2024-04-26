package com.example.supermercato.controller;

import com.example.supermercato.model.Admin;
import com.example.supermercato.service.AdminService;
import com.example.supermercato.service.ProdottoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/riservatoadmin")
public class RiservatoAdminController {

    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String getPage(Model model, HttpSession session) {

        if(session.getAttribute("admin") == null)
            return "redirect:/loginadmin";
        Admin admin = (Admin) session.getAttribute("admin");
        model.addAttribute("admin", admin);
        return "riservatoadmin";
    }

    @GetMapping
    public String logoutAdmin(HttpSession session) {

        session.removeAttribute("admin");
        return "redirect:/";
    }

}
