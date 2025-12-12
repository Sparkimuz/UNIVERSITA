package com.leocentu.progettopersonale.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Musicista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cognome;

//  @Min(1908)
//  @Max(2024)
    private LocalDate dataNascita;
    private int votoTotale;

    @OneToMany(mappedBy="musicista", cascade = CascadeType.ALL)
    private List<Album> album;

    @OneToOne
    private Credenziali credenziali;

    @OneToMany(mappedBy = "destinatario")
    private List<Votazione> votazioni;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public int getVotoTotale() {
        return votoTotale;
    }

    public void setVotoTotale(int votoTotale) {
        this.votoTotale = votoTotale;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public Credenziali getCredenziali() {
        return credenziali;
    }

    public void setCredenziali(Credenziali credenziali) {
        this.credenziali = credenziali;
    }

    public List<Votazione> getVotazioni() {
        return votazioni;
    }

    public void setVotazioni(List<Votazione> votazioni) {
        this.votazioni = votazioni;
    }
}