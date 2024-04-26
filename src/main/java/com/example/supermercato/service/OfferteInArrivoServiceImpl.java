package com.example.supermercato.service;

import com.example.supermercato.dao.OfferteInArrivoDao;
import com.example.supermercato.model.OfferteInArrivo;
import com.example.supermercato.model.Sottocategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OfferteInArrivoServiceImpl implements OfferteInArrivoService {
    @Autowired
    private SottocategoriaService sottocategoriaService;

    @Autowired
    private ValoreOffertaService valoreOffertaService;

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

    @Override
    public void cancellaOffertaInArrivo(int id) {
        offerteInArrivoDao.deleteById(id);
    }

    @Override
    public void aggiungiOffertaInArrivo(OfferteInArrivo nuovaOfferta, int idSottocategoria, int idValoreOfferta, LocalDate dataInizio, LocalDate dataFine) {
        nuovaOfferta.setSottocategoria(sottocategoriaService.getSottocategoriaById(idSottocategoria));
        nuovaOfferta.setValoreOfferta(valoreOffertaService.getValoreOffertaById(idValoreOfferta));
        nuovaOfferta.setDataInizio(dataInizio);
        nuovaOfferta.setDataFine(dataFine);

        offerteInArrivoDao.save(nuovaOfferta);
    }

    @Override
    public void attivaOfferta(int idOfferta, int idSottocategoria, int idValore) {
       Sottocategoria sottocategoria = sottocategoriaService.getSottocategoriaById(idSottocategoria);
       sottocategoria.setStatoOfferta(true);
       sottocategoria.setValoreOfferta(valoreOffertaService.getValoreOffertaById(idValore));
       offerteInArrivoDao.deleteById(idOfferta);
    }

}
