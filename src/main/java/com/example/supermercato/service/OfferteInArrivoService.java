package com.example.supermercato.service;

import com.example.supermercato.model.OfferteInArrivo;

import java.util.List;

public interface OfferteInArrivoService {

    OfferteInArrivo getOfferteInArrivoById(int id);
    List<OfferteInArrivo> getOfferteInArrivo();

}

