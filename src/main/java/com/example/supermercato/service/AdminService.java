package com.example.supermercato.service;

import com.example.supermercato.model.Admin;
import com.example.supermercato.model.Prodotto;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface AdminService {

    List<Admin> getAdmin();

    Admin getAdminById(int id);

    boolean loginAdmin(String username, String password, HttpSession session);

    void registraAdmin(Admin admin);

    boolean controlloUsername(String username);
}
