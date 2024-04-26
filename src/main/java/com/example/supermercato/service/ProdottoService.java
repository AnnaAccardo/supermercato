package com.example.supermercato.service;

import com.example.supermercato.model.Prodotto;

import java.util.List;

public interface ProdottoService {

    List<Prodotto> getProdotti();
    List<Prodotto> getProdottiBySottocategoriaId(int idSottocategoria);
    Prodotto getProdottoById(int id);
    void registraProdotto(Prodotto prodotto);
    void cancellaProdotto(int idProdotto);
}
