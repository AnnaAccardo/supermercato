package com.example.supermercato.service;

import com.example.supermercato.dao.SottocategoriaDao;
import com.example.supermercato.model.Sottocategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SottocategoriaServiceImpl implements SottocategoriaService{
    @Autowired
    private SottocategoriaDao sottocategoriaDao;

    @Override
    public Sottocategoria getSottocategoriaById(int idSottocategoria) {
        return sottocategoriaDao.findById(idSottocategoria).get();
    }

    @Override
    public List<Sottocategoria> getSottocategorie() {
        return (List<Sottocategoria>) sottocategoriaDao.findAll();
    }

    @Override
    public void registraSottocategoria(Sottocategoria sottocategoria) {
        sottocategoriaDao.save(sottocategoria);
    }

    @Override
    public void cancellaSottocategoria(int idSottocategoria) {
        sottocategoriaDao.deleteById(idSottocategoria);
    }
}
