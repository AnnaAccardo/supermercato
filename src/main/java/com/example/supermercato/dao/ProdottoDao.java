package com.example.supermercato.dao;

import com.example.supermercato.model.Prodotto;
import org.springframework.data.repository.CrudRepository;

public interface ProdottoDao extends CrudRepository<Prodotto, Integer> {

}
