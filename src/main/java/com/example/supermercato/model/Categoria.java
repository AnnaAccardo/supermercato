package com.example.supermercato.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @OneToMany(
            mappedBy = "categoria",
            cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER
    )
    private List<Sottocategoria> sottoCategorie = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Sottocategoria> getSottoCategorie() {
        return sottoCategorie;
    }

    public void setSottoCategorie(List<Sottocategoria> sottoCategorie) {
        this.sottoCategorie = sottoCategorie;
    }
}
