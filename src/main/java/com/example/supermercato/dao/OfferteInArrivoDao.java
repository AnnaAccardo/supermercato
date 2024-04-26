package com.example.supermercato.dao;

import com.example.supermercato.model.OfferteInArrivo;
import org.springframework.data.repository.CrudRepository;
import com.example.supermercato.model.ValoreOfferta;
import org.springframework.data.repository.CrudRepository;

public interface OfferteInArrivoDao extends CrudRepository<OfferteInArrivo, Integer> {

   // ValoreOfferta findByOfferteInArrivoIdSottoCategoriaAndIdValoreOffertaAndDataInizioAndDataFine(int idSottoCategoria, int idValoreOfferta, String dataInizio, String dataFine);
}
