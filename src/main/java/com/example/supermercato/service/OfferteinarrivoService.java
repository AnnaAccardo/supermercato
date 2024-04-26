package com.example.supermercato.service;

import com.example.supermercato.model.OfferteInArrivo;
import com.example.supermercato.model.Prodotto;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface OfferteInArrivoService {

    OfferteInArrivo getOfferteInArrivoById(int id);
    List<OfferteInArrivo> getOfferteInArrivo();
    void cancellaOffertaInArrivo(int id);
    void aggiungiOffertaInArrivo(OfferteInArrivo nuovaOfferta,int idSottocategoria, int idValoreOfferta, LocalDate dataInizio, LocalDate dataFine);
}