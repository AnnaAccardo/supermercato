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

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private SottocategoriaService sottocategoriaService;

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public String getPage(
            Model model,
            @RequestParam(name = "errorericerca", required = false) String erroreRicerca
    ){
        List<Prodotto> prodotti = prodottoService.getProdotti();
        List<Categoria> categorie = categoriaService.getCategorie();
        model.addAttribute("categorie", categorie);
        model.addAttribute("prodotti", prodotti);
        model.addAttribute("errorericerca", erroreRicerca);
        return "index";
    }

    @GetMapping("/offerte")
    public String offerte(
            @RequestParam("id") int idCategoria,
            Model model
    ){

        Categoria categoria = categoriaService.getCategoriaById(idCategoria);
        List<Sottocategoria> sottocategorie = sottocategoriaService.getOfferte(idCategoria);
        List<Prodotto> prodotti = prodottoService.getProdotti();
        model.addAttribute("sottocategorie", sottocategorie);
        model.addAttribute("categoria", categoria);
        model.addAttribute("prodotti", prodotti);
        return "offerte";
    }

    @GetMapping("/ricerca")
    public String ricerca(@RequestParam("nome") String nome, Model model) {
        Categoria categoria = categoriaService.getCategoriaByNome(nome);
        int idCategoria = 0;

        if(categoria != null){
            idCategoria = categoria.getId();
            return "redirect:/offerte?id=" + idCategoria;
        }
           return "redirect:/?errorericerca";
    }
}
