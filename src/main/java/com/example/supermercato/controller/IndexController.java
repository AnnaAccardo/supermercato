package com.example.supermercato.controller;

import com.example.supermercato.model.Categoria;
import com.example.supermercato.model.Prodotto;
import com.example.supermercato.model.Sottocategoria;
import com.example.supermercato.service.CategoriaService;
import com.example.supermercato.service.ProdottoService;
import com.example.supermercato.service.SottocategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public String getPage(
            Model model
    ){
        List<Prodotto> prodotti = prodottoService.getProdotti().stream()
                                                                .filter(p -> p.getSottocategoria().getStatoOfferta())
                                                                .collect(Collectors.toList());
        List<Categoria> categorie = categoriaService.getCategorie();
        model.addAttribute("categorie", categorie);
        model.addAttribute("prodotti", prodotti);
        return "index";
    }

    @GetMapping("/chisiamo")
    public String chiSiamo(){
        return "chisiamo";
    }
}
