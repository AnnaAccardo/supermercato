package com.example.supermercato.controller;

import com.example.supermercato.model.Prodotto;
import com.example.supermercato.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public String getPage(@RequestParam("id") int id, Model model) {

        Prodotto prodotto = prodottoService.getProdottoById(id);
        model.addAttribute("prodotto", prodotto);
        return "dettaglio";
    }

}
