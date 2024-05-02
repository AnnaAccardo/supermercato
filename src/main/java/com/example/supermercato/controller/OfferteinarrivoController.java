package com.example.supermercato.controller;

import com.example.supermercato.model.*;
import com.example.supermercato.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/offerteinarrivo")
public class OfferteinarrivoController {

    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private OfferteInArrivoService offerteInArrivoService;

    @Autowired
    private SottocategoriaService sottocategoriaService;

    @Autowired
    private ValoreOffertaService valoreOffertaService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String getPage(Model model, HttpSession session){

        List<Prodotto> prodotti = prodottoService.getProdotti();
        List<OfferteInArrivo> offerte = offerteInArrivoService.getOfferteInArrivo();
        List<Sottocategoria> sottocategorie = sottocategoriaService.getSottocategorie();
        List<ValoreOfferta> valoreOfferta = valoreOffertaService.getValoreOfferta();
        List<Categoria> categorie = categoriaService.getCategorie();

        model.addAttribute("prodotti", prodotti);
        model.addAttribute("offerte", offerte);
        model.addAttribute("sottocategorie", sottocategorie);
        model.addAttribute("valoreofferta", valoreOfferta);
        model.addAttribute("categorie", categorie);

        return "offerteinarrivo";
    }

}
