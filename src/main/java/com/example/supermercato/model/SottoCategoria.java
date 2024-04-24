package com.example.supermercato.model;

import jakarta.persistence.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sottocategorie")
public class SottoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String marca;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;

    @Column(name = "stato_offerta")
    private boolean statoOfferta;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_valore_offerta", referencedColumnName = "id")
    private ValoreOfferta valoreOfferta;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable
            (
                    name = "offerte_in_arrivo",
                    joinColumns = @JoinColumn(name = "id_sottocategoria", referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(name = "id_valore_offerta", referencedColumnName = "id")
            )
    private List<ValoreOfferta> valoreOfferte = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isStatoOfferta() {
        return statoOfferta;
    }

    public void setStatoOfferta(boolean statoOfferta) {
        this.statoOfferta = statoOfferta;
    }

    public ValoreOfferta getValoreOfferta() {
        return valoreOfferta;
    }

    public void setValoreOfferta(ValoreOfferta valoreOfferto) {
        this.valoreOfferta = valoreOfferto;
    }

    public List<ValoreOfferta> getValoreOfferte() {
        return valoreOfferte;
    }

    public void setValoreOfferte(List<ValoreOfferta> valoreOfferte) {
        this.valoreOfferte = valoreOfferte;
    }
}