package com.example.supermercato.service;

import com.example.supermercato.model.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria getCategoriaById(int idCategoria);
    List<Categoria> getCategorie();
    void registraCategoria(Categoria categoria);
    void cancellaCategoria(int idCategoria);
}
