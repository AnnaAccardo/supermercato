package com.example.supermercato.service;

import com.example.supermercato.dao.ValoreOffertaDao;
import com.example.supermercato.model.ValoreOfferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoreOffertaServiceImpl implements ValoreOffertaService{

    @Autowired
    private ValoreOffertaDao valoreOffertaDao;

    @Override
    public List<ValoreOfferta> getValoreOfferta() {
        return (List<ValoreOfferta>) valoreOffertaDao.findAll();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public ValoreOfferta getValoreOffertaById(int id) {
        return valoreOffertaDao.findById(id).get();
    }
}
