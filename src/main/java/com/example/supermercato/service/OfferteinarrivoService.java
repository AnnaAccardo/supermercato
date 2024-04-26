package com.example.supermercato.service;

import com.example.supermercato.model.Categoria;
import com.example.supermercato.model.Offerteinarrivo;

import java.util.List;

public interface OfferteinarrivoService {

    Offerteinarrivo getOfferteinarrivoById(int id);
    List<Offerteinarrivo> getOfferteinarrivo();

}
