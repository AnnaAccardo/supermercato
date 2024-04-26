package com.example.supermercato.service;

import com.example.supermercato.dao.OfferteInArrivoDao;
import com.example.supermercato.model.OfferteInArrivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferteInArrivoServiceImpl implements OfferteInArrivoService {

    @Autowired
    private OfferteInArrivoDao offerteInArrivoDao;

    @Override
    public OfferteInArrivo getOfferteInArrivoById(int id) {
        Optional<OfferteInArrivo> optionalOfferte = offerteInArrivoDao.findById(id);
        if (optionalOfferte.isPresent())
            return optionalOfferte.get();
        return null;
    }

    @Override
    public List<OfferteInArrivo> getOfferteInArrivo() {
        return (List<OfferteInArrivo>) offerteInArrivoDao.findAll();
    }
}

