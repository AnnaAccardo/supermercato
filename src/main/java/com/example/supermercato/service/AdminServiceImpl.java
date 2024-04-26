package com.example.supermercato.service;

import com.example.supermercato.dao.AdminDao;
import com.example.supermercato.model.Admin;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean loginAdmin(String nome, String cognome, String username, String password, HttpSession session) {

        Admin admin = (Admin) adminDao.findAll();
        if(admin != null) {
            session.setAttribute("admin", admin);
            return true;
        }
        return false;
    }

    @Override
    public void registraAdmin(Admin admin) {

        adminDao.save(admin);
    }

    @Override
    public boolean controlloUsername(String username) {

        if(adminDao.findByUsername(username) == null)
            return true;
        return false;
    }

}