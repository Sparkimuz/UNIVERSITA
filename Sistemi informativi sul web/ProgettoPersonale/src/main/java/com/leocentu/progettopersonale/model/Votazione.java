package com.leocentu.progettopersonale.model;
import jakarta.persistence.*;

@Entity
public class Votazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mittenteId;
    @ManyToOne
    private Musicista destinatario;
    @ManyToOne
    private Album album;
    private int voto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMittenteId() {
        return mittenteId;
    }

    public void setMittenteId(Long mittenteId) {
        this.mittenteId = mittenteId;
    }

    public Musicista getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Musicista destinatario) {
        this.destinatario = destinatario;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
}