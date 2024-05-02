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
    public List<Sottocategoria> getSottocategorieAlfabetico() {
        return (List<Sottocategoria>) sottocategoriaDao.findAllByOrderByMarcaAsc();
    }

    @Override
    public List<Sottocategoria> getSottocategorieByCategoriaId(int idCategoria) {
        return (List<Sottocategoria>) sottocategoriaDao.findByCategoriaId(idCategoria);
    }

    @Override
    public List<Sottocategoria> getOfferte(int idCategoria) {
        return (List<Sottocategoria>) sottocategoriaDao.findDistinctByCategoriaIdAndStatoOffertaIsTrue(idCategoria);
    }

    @Override
    public void registraSottocategoria(Sottocategoria sottocategoria) {
        sottocategoriaDao.save(sottocategoria);
    }

    @Override
    public void cancellaSottocategoria(int idSottocategoria) {
        sottocategoriaDao.deleteById(idSottocategoria);
    }

    @Override
    public void disattivaOfferta(int idSottocategoria) {
        Sottocategoria sottocategoria = sottocategoriaDao.findById(idSottocategoria).get();

        sottocategoria.setValoreOfferta(null);
        sottocategoria.setStatoOfferta(false);
        sottocategoriaDao.save(sottocategoria);
    }
}
