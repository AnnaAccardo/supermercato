package com.example.supermercato.dao;

import com.example.supermercato.model.Offerteinarrivo;
import com.example.supermercato.model.ValoreOfferta;
import org.springframework.data.repository.CrudRepository;

public interface OfferteinarrivoDao extends CrudRepository<Offerteinarrivo, Integer> {

   // ValoreOfferta findByOfferteInArrivoIdSottoCategoriaAndIdValoreOffertaAndDataInizioAndDataFine(int idSottoCategoria, int idValoreOfferta, String dataInizio, String dataFine);
}
