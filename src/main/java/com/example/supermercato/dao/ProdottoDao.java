package com.example.supermercato.dao;

import com.example.supermercato.model.Prodotto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdottoDao extends CrudRepository<Prodotto, Integer> {
    List<Prodotto> findBySottocategoriaId(int idSottocategoria);
    List<Prodotto> findBySottocategoriaCategoriaId(int idCategoria);
    List<Prodotto> findByNome(String nome);
}
