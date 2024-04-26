package com.example.supermercato.dao;

import com.example.supermercato.model.Sottocategoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SottocategoriaDao extends CrudRepository<Sottocategoria, Integer> {
    List<Sottocategoria> findByCategoriaId(int idCategoria);
    List<Sottocategoria> findDistinctByCategoriaIdAndStatoOffertaIsTrue(int idCategoria);
}
