package com.example.supermercato.service;

import com.example.supermercato.model.Admin;
import jakarta.servlet.http.HttpSession;

public interface AdminService {

    boolean loginAdmin(String nome, String cognome, String username, String password, HttpSession session);

    void registraAdmin(Admin admin);

    boolean controlloUsername(String username);
}
