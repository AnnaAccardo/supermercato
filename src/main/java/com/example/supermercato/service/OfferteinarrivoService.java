package com.example.supermercato.service;

import com.example.supermercato.model.OfferteInArrivo;
import com.example.supermercato.model.Prodotto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OfferteInArrivoService {

    OfferteInArrivo getOfferteInArrivoById(int id);
    List<OfferteInArrivo> getOfferteInArrivo();

    void registraOfferte(OfferteInArrivo offerteInArrivo, int idSottoCategoria, int idValoreOfferta, String dataInizio, String dataFine);
    void cancellaOfferte(int idOfferteInArrivo);


}