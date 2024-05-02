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
import java.util.stream.Collectors;

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
        Categoria categoria = null;
        List<Categoria> categorie = categoriaService.getCategorie();
        model.addAttribute("categorie", categorie);

        if(idCategoria != null){
            categoria = categoriaService.getCategoriaById(Integer.parseInt(idCategoria));
            List<Sottocategoria> sottocategorie = sottocategoriaService.getSottocategorieByCategoriaId(Integer.parseInt(idCategoria));
            model.addAttribute("sottocategorie", sottocategorie);
        }

        List<Prodotto> prodotti;
        if(ricerca != null) {
            prodotti = prodottoService.getProdottiByNome(ricerca);
            if(!prodotti.isEmpty())
                categoria = categoriaService.getCategoriaById(prodotti.get(0).getSottocategoria().getCategoria().getId());
        }else{
            prodotti = idCategoria == null ? prodottoService.getProdotti() : prodottoService.getProdottiByCategoriaId(Integer.parseInt(idCategoria));
        }
        model.addAttribute("prodotti", prodotti.stream().filter(p -> p.getSottocategoria().getStatoOfferta()).collect(Collectors.toList()));
        model.addAttribute("categoria", categoria);

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
