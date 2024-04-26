package com.example.supermercato.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/adminprodotti")
public class AdminProdottiController {

    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private SottocategoriaService sottocategoriaService;

    @Autowired
    private CategoriaService categoriaService;

    private Prodotto prodotto;

    @GetMapping
    public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id, HttpSession session) {


        if(session.getAttribute("admin") == null)
            return "redirect:/loginadmin";
        List<Prodotto> prodotti = prodottoService.getProdotti();
        List<Sottocategoria> sottocategorie = sottocategoriaService.getSottocategorie();
        prodotto = id == null ? new Prodotto() : prodottoService.getProdottoById(id);
        model.addAttribute("prodotti", prodotti);
        model.addAttribute("sottocategorie", sottocategorie);
        model.addAttribute("prodotto", prodotto);
        return "adminprodotti";
    }

    @PostMapping
    public String getForm(@RequestParam("nome") String nome,
                          @RequestParam("prezzo") String prezzo,
                          @RequestParam("descrizione") String descrizione,
                          @RequestParam("sottocategorie") int idSottocategorie,
                          @RequestParam(name = "immagine", required = false) MultipartFile immagine) {

        prodottoService.registraProdotto(prodotto, nome, prezzo, descrizione, idSottocategorie, immagine);

        return "redirect:/adminprodotti";
    }

    @GetMapping("/elimina")
    public String eliminaProdotto(@RequestParam("id") int id) {

        prodottoService.cancellaProdotto(id);
        return "redirect:/adminprodotti";
    }

}
