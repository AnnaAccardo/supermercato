package com.example.supermercato.service;

import com.example.supermercato.model.ValoreOfferta;

import java.util.List;

public interface ValoreOffertaService {

    List<ValoreOfferta> getValoreOfferta();
    ValoreOfferta getValoreOffertaById(int id);

}
