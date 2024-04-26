package com.example.supermercato.service;

import com.example.supermercato.dao.ProdottoDao;
import com.example.supermercato.dao.SottocategoriaDao;
import com.example.supermercato.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@Service
public class ProdottoServiceImpl implements ProdottoService{

    @Autowired
    private ProdottoDao prodottoDao;

    @Autowired
    private SottocategoriaService sottocategoriaService;

    @Override
    public List<Prodotto> getProdotti() {
        return (List<Prodotto>) prodottoDao.findAll();
    }

    @Override
    public List<Prodotto> getProdottiBySottocategoriaId(int idSottocategoria) {
        return (List<Prodotto>) prodottoDao.findBySottocategoriaId(idSottocategoria);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public Prodotto getProdottoById(int id) {
        return prodottoDao.findById(id).get();
    }

    @Override
    public void registraProdotto(Prodotto prodotto, String nome, String prezzo, String descrizione, int idSottoCategoria, MultipartFile immagine) {

        prodotto.setNome(nome);
        prodotto.setPrezzo(Double.parseDouble(prezzo));
        prodotto.setDescrizione(descrizione);
        prodotto.setSottocategoria(sottocategoriaService.getSottocategoriaById(idSottoCategoria));
        if(immagine != null && !immagine.isEmpty()) {

            try {

                String formato = immagine.getContentType();
                String copertinaCodificata = "data:" + formato + ";base64," + Base64.getEncoder().encodeToString(immagine.getBytes());

                prodotto.setImmagine(copertinaCodificata);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        prodottoDao.save(prodotto);
    }

    @Override
    public void cancellaProdotto(int idProdotto) {
        prodottoDao.deleteById(idProdotto);
    }
}
