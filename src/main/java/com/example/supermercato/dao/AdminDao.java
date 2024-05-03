package com.example.supermercato.dao;

import com.example.supermercato.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<Admin, Integer> {

    Admin findByNomeAndCognomeAndUsernameAndPassword(String nome, String cognome, String username, String password);
}