package com.example.supermercato.service;

import com.example.supermercato.model.Prodotto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProdottoService {

    List<Prodotto> getProdotti();
    List<Prodotto> getProdottiBySottocategoriaId(int idSottocategoria);
    Prodotto getProdottoById(int id);
    void registraProdotto(Prodotto prodotto, String nome, String prezzo, String descrizione, int idSottoCategoria, MultipartFile immagine);
    void cancellaProdotto(int idProdotto);
}
