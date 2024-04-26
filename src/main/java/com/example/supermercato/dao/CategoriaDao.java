package com.example.supermercato.dao;

import com.example.supermercato.model.Categoria;
import com.example.supermercato.model.Prodotto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaDao extends CrudRepository<Categoria, Integer> {

    List<Categoria> findByNomeContaining(String nome);
}
