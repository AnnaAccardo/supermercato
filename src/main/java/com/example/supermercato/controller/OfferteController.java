package com.example.supermercato.controller;

import com.example.supermercato.model.Categoria;
import com.example.supermercato.model.Prodotto;
import com.example.supermercato.model.Sottocategoria;
import com.example.supermercato.service.CategoriaService;
import com.example.supermercato.service.ProdottoService;
import com.example.supermercato.service.SottocategoriaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/offerte")
public class OfferteController {
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private SottocategoriaService sottocategoriaService;

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public String getPage(
            @RequestParam(name = "id", required = false) String idCategoria,
            @RequestParam(name = "ricerca", required = false) String ricerca,
            Model model
    ){
        List<Categoria> categorie = categoriaService.getCategorie();
        model.addAttribute("categorie", categorie);

        if(idCategoria != null){
            Categoria categoria = categoriaService.getCategoriaById(Integer.parseInt(idCategoria));
            model.addAttribute("categoria", categoria);
            List<Sottocategoria> sottocategorie = sottocategoriaService.getSottocategorieByCategoriaId(Integer.parseInt(idCategoria));
            model.addAttribute("sottocategorie", sottocategorie);
        }

        List<Prodotto> prodotti;
        if(ricerca != null) {
            prodotti = prodottoService.getProdottiByNome(ricerca);
        }else{
            prodotti = idCategoria == null ? prodottoService.getProdotti() : prodottoService.getProdottiByCategoriaId(Integer.parseInt(idCategoria));
        }
        model.addAttribute("prodotti", prodotti);

        return "offerte";
    }

    @GetMapping("/ricerca")
    public String ricerca(
            @RequestParam("prodottocercato") String prodotto
    ) {
        if(prodotto != null && !prodotto.isEmpty())
            return "redirect:/offerte?ricerca=" + prodotto;
        return "redirect:/offerte";
    }
}
