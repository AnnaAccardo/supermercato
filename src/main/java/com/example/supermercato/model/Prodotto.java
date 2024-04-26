package com.example.supermercato.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prodotti")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private double prezzo;

    @Column
    private String descrizione;

    @Column
    private String immagine;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name= "id_sottocategoria", referencedColumnName = "id")
    private Sottocategoria sottocategoria;

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

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public Sottocategoria getSottocategoria() {
        return sottocategoria;
    }

    public void setSottocategoria(Sottocategoria sottocategoria) {
        this.sottocategoria = sottocategoria;
    }
}
