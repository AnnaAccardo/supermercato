package com.example.supermercato.dao;

import com.example.supermercato.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria, Integer> {
}
