package com.example.supermercato.controller;

import com.example.supermercato.model.OfferteInArrivo;
import com.example.supermercato.model.Prodotto;
import com.example.supermercato.model.Sottocategoria;
import com.example.supermercato.model.ValoreOfferta;
import com.example.supermercato.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
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

    @Autowired
    private ValoreOffertaService valoreOffertaService;

    private Prodotto prodotto;
    private OfferteInArrivo offertaInArrivo;

    @Autowired
    private OfferteInArrivoService offerteInArrivoService;

    @GetMapping
    public String getPage(
            Model model,
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "idOff", required = false) Integer idOff,
            HttpSession session
    ){


        if(session.getAttribute("admin") == null)
            return "redirect:/loginadmin";
        List<Prodotto> prodotti = prodottoService.getProdotti();
        model.addAttribute("prodotti", prodotti);

        List<Sottocategoria> sottocategorie = sottocategoriaService.getSottocategorie();
        model.addAttribute("sottocategorie", sottocategorie);

        List<OfferteInArrivo> offerte = offerteInArrivoService.getOfferteInArrivo();
        model.addAttribute("offerte",offerte);

        prodotto = id == null ? new Prodotto() : prodottoService.getProdottoById(id);
        model.addAttribute("prodotto", prodotto);

        offertaInArrivo = idOff == null ? new OfferteInArrivo() : offerteInArrivoService.getOfferteInArrivoById(idOff);
        model.addAttribute("offertainarrivo", offertaInArrivo);

        List<ValoreOfferta> valoreOfferta = valoreOffertaService.getValoreOfferta();
        model.addAttribute("valoreofferta", valoreOfferta);

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

    @PostMapping("/aggiungiofferta")
    public String formManager(
            @RequestParam("sottocategorie") int idSottocategorie,
            @RequestParam("valoriofferte") int idValoreOfferta,
            @RequestParam("datainizio")LocalDate dataInizio,
            @RequestParam("datafine") LocalDate dataFine
            ){
        offerteInArrivoService.aggiungiOffertaInArrivo(offertaInArrivo, idSottocategorie, idValoreOfferta, dataInizio, dataFine);
        return "redirect:/adminprodotti";
    }

    @GetMapping("/elimina")
    public String eliminaProdotto(@RequestParam("id") int id) {

        prodottoService.cancellaProdotto(id);
        return "redirect:/adminprodotti";
    }

    @GetMapping("/eliminaOff")
    public String eliminaOfferta(
            @RequestParam("idOff") int idOff
    ){
        offerteInArrivoService.cancellaOffertaInArrivo(idOff);
        return "redirect:/adminprodotti";
    }

    @GetMapping("/attivaofferta")
    public String attivaOfferta(
            @RequestParam("idOff") int idOff,
            @RequestParam("idSott") int idSott,
            @RequestParam("idVal") int idVal
    ){

        offerteInArrivoService.attivaOfferta(idOff, idSott, idVal);
        return "redirect:/adminprodotti";
    }

    @GetMapping("/disattivaofferta")
    public String disattivaOfferta(
        @RequestParam("idSott") int idSott
    ){
        sottocategoriaService.disattivaOfferta(idSott);
        return "redirect:/adminprodotti";
    }
}
