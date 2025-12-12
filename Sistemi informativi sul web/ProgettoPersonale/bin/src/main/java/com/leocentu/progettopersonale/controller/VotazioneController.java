package com.leocentu.progettopersonale.controller;

import com.leocentu.progettopersonale.Comparator.ComparatoreAlbum;
import com.leocentu.progettopersonale.model.Album;
import com.leocentu.progettopersonale.model.Credenziali;
import com.leocentu.progettopersonale.model.Musicista;
import com.leocentu.progettopersonale.model.Votazione;
import com.leocentu.progettopersonale.repository.AlbumRepository;
import com.leocentu.progettopersonale.service.AlbumService;
import com.leocentu.progettopersonale.service.CredenzialiService;
import com.leocentu.progettopersonale.service.MusicistaService;
import com.leocentu.progettopersonale.service.VotazioneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Controller
public class VotazioneController {
    @Autowired
    private AlbumService albumService;

    @Autowired
    private VotazioneService votazioneService;
    @Autowired
    private CredenzialiService credenzialiService;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private MusicistaService musicistaService;

    @RequestMapping("/votazione")
    public String votazione(@RequestParam(value = "username") String username, @RequestParam(value = "titolo", required = false) String titolo, Model model) {
        List<Album> album = new ArrayList<>(albumService.findAll());
        album.sort(new ComparatoreAlbum());
        model.addAttribute("username", username);
        if (titolo != null) {
            List<Album> listaNuova = new ArrayList<>();
            for (Album albumSingolo : album) {
                if (albumSingolo.getTitolo().equals(titolo)) {
                    listaNuova.add(albumSingolo);
                }
            }
            if (listaNuova.isEmpty()) {
                model.addAttribute("errore", "Nessun album trovato con questo titolo!");
                return "votazione";
            }
            model.addAttribute("album", listaNuova);
            return "votazione";
        }
        model.addAttribute("album", album);
        return "votazione";
    }

    @GetMapping("/votaAlbum")
    public String votaAlbum(@RequestParam("username") String username, @RequestParam("albumId") Long albumId, Model model, RedirectAttributes redirectAttributes) {
        Album album = albumService.findById(albumId);
        List<Album> albumList = albumService.findAll();
        if (username.equals(album.getMusicista().getCredenziali().getUsername())) {
            model.addAttribute("stessoUtente", "Non puoi votare un album di cui sei il musicista!");
            model.addAttribute("album", albumList);
            model.addAttribute("username", username);
            return "votazione";
        }

        model.addAttribute("album", album);
        model.addAttribute("username", username);
        redirectAttributes.addAttribute("votato", "Il tuo voto è stato salvato con successo!");
        return "votaAlbum";
    }

    @PostMapping("/inviaVoto")
    public String inviaVoto(@RequestParam(value = "username") String username, @RequestParam("voto") int voto, @RequestParam("albumId") Long albumId, Model model) {
        List<Votazione> votazioni = votazioneService.findAll();
        Long utenteId = credenzialiService.findIdByUsername(username);
        for (Votazione votazione : votazioni) {
            if (Objects.equals(votazione.getMittenteId(), utenteId) && votazione.getAlbum().equals(albumService.findById(albumId))) {
                model.addAttribute("votoPassato", "Hai già votato questo testo! Elimina il voto per eseguirne un altro!");
                List<Album> album = albumService.findAll();
                album.sort(new ComparatoreAlbum());
                model.addAttribute("username", username);
                model.addAttribute("album", album);
                return "votazione";
            }
        }
        Musicista musicista = albumService.findById(albumId).getMusicista();
        Votazione votazione = new Votazione();
        votazione.setMittenteId(utenteId);
        votazione.setDestinatario(musicista);
        votazione.setAlbum(albumService.findById(albumId));
        votazione.setVoto(voto);
        votazioneService.save(votazione);
        int votoMusicista = musicista.getVotoTotale();
        int nuovoVotoMusicista = votoMusicista + voto;
        musicista.setVotoTotale(nuovoVotoMusicista);
        musicistaService.save(musicista);
        Album album = albumService.findById(albumId);
        int nuovoVoto = album.getVoto() + voto;
        album.setVoto(nuovoVoto);
        albumService.save(album);
        List<Album> albumList = albumService.findAll();
        albumList.sort(new ComparatoreAlbum());
        model.addAttribute("username", username);
        model.addAttribute("album", albumList);
        model.addAttribute("votoInviato", "Voto salvato con successo!");
        return "votazione";
    }

    @GetMapping("/eliminaVoto")
    public String eliminaVoto(@RequestParam("username") String username, @RequestParam("albumId") Long albumId, Model model) {
        model.addAttribute("username", username);
        Album album = albumService.findById(albumId);
        List<Votazione> votazioni = votazioneService.findAll();
        Long utenteId = credenzialiService.findIdByUsername(username);
        for (Votazione votazione : votazioni) {
            if (Objects.equals(votazione.getMittenteId(), utenteId) && Objects.equals(votazione.getAlbum(), albumService.findById(albumId))) {
                int votoSingolo = votazione.getVoto();
                int votoNuovo = album.getVoto() - votoSingolo;
                album.setVoto(votoNuovo);
                albumService.save(album);
                Musicista musicista = album.getMusicista();
                int votoMusicista = musicista.getVotoTotale();
                int nuovoVotoMusicista = votoMusicista - votazione.getVoto();
                musicista.setVotoTotale(nuovoVotoMusicista);
                musicistaService.save(musicista);
                votazioneService.delete(votazione);
                model.addAttribute("votoEliminato", "Il voto è stato eliminato con successo!");
                List<Album> albumList = albumService.findAll();
                albumList.sort(new ComparatoreAlbum());
                model.addAttribute("album", albumList);
                return "votazione";
            }
        }
        model.addAttribute("nonVotato", "Non hai votato questo album!");
        List<Album> albumList = albumService.findAll();
        albumList.sort(new ComparatoreAlbum());
        model.addAttribute("album", albumList);
        return "votazione";
    }
}