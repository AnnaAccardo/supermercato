package com.example.supermercato.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "offerte_in_arrivo")
public class OfferteInArrivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_valore_offerta", referencedColumnName = "id")
    private ValoreOfferta valoreOfferta;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name= "id_sottocategoria", referencedColumnName = "id")
    private Sottocategoria sottocategoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public ValoreOfferta getValoreOfferta() {
        return valoreOfferta;
    }

    public void setValoreOfferta(ValoreOfferta valoreOfferta) {
        this.valoreOfferta = valoreOfferta;
    }

    public Sottocategoria getSottocategoria() {
        return sottocategoria;
    }

    public void setSottocategoria(Sottocategoria sottocategoria) {
        this.sottocategoria = sottocategoria;
    }
}