package com.example.supermercato.service;

import com.example.supermercato.dao.CategoriaDao;
import com.example.supermercato.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public Categoria getCategoriaById(int idCategoria) {
        return categoriaDao.findById(idCategoria).get();
    }

    @Override
    public List<Categoria> getCategorie() {
        return (List<Categoria>) categoriaDao.findAll();
    }
}
