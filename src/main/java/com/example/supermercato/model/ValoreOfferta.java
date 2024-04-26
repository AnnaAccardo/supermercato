package com.example.supermercato.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "valori_offerte")
public class ValoreOfferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int valore;

    @ManyToMany(

            cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "offerta_in_arrivo",
            joinColumns = @JoinColumn(name = "id_valore_offerta", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_sottocategoria", referencedColumnName = "id")
    )
    private List<SottoCategoria> sottoCategorie = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public List<SottoCategoria> getSottoCategorie() {
        return sottoCategorie;
    }

    public void setSottoCategorie(List<SottoCategoria> sottoCategorie) {
        this.sottoCategorie = sottoCategorie;
    }
}
