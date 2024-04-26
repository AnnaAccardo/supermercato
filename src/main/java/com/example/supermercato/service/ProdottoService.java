package com.example.supermercato.service;

import com.example.supermercato.model.Prodotto;

import java.util.List;

public interface ProdottoService {

    List<Prodotto> getProdotto();
    Prodotto getProdottoById(int id);
}
