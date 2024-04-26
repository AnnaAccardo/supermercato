package com.example.supermercato.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "offerte_in_arrivo")
public class Offerteinarrivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDate dataInizio;

    @Column
    private LocalDate dateFine;

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

    public LocalDate getDateFine() {
        return dateFine;
    }

    public void setDateFine(LocalDate dateFine) {
        this.dateFine = dateFine;
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
