package com.example.supermercato.service;

import com.example.supermercato.dao.OfferteinarrivoDao;
import com.example.supermercato.model.Offerteinarrivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferteinarrivoServiceImpl implements OfferteinarrivoService{

    @Autowired
    private OfferteinarrivoDao offerteinarrivoDao;

    @Override
    public Offerteinarrivo getOfferteinarrivoById(int id) {
        Optional<Offerteinarrivo> optionalOfferte = offerteinarrivoDao.findById(id);
        if (optionalOfferte.isPresent())
            return optionalOfferte.get();
        return null;
    }

    @Override
    public List<Offerteinarrivo> getOfferteinarrivo() {
        return (List<Offerteinarrivo>) offerteinarrivoDao.findAll();
    }
}
