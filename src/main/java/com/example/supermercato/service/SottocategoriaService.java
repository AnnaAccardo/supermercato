package com.example.supermercato.service;

import com.example.supermercato.model.Sottocategoria;

import java.util.List;

public interface SottocategoriaService {
    Sottocategoria getSottocategoriaById(int idSottocategoria);
    List<Sottocategoria> getSottocategorie();
    List<Sottocategoria> getSottocategorieByCategoriaId(int idCategoria);
    List<Sottocategoria> getOfferte(int idCategoria);
    void registraSottocategoria(Sottocategoria sottocategoria);
    void cancellaSottocategoria(int idSottocategoria);

}
