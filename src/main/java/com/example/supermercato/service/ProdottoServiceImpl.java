package com.example.supermercato.service;

import com.example.supermercato.dao.ProdottoDao;
import com.example.supermercato.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoServiceImpl implements ProdottoService{

    @Autowired
    private ProdottoDao prodottoDao;


    @Override
    public List<Prodotto> getProdotto() {
        return (List<Prodotto>) prodottoDao.findAll();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public Prodotto getProdottoById(int id) {
        return prodottoDao.findById(id).get();
    }
}