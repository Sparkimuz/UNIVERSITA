package com.leocentu.progettopersonale.controller;

import com.leocentu.progettopersonale.model.Album;
import com.leocentu.progettopersonale.model.Musicista;
import com.leocentu.progettopersonale.service.AlbumService;
import com.leocentu.progettopersonale.service.MusicistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class ClassificaController {
    @Autowired
    private MusicistaService musicistaService;

    @Autowired
    private AlbumService albumService;

    @GetMapping("/classifica")
    public String classifica(@RequestParam(value = "cognome", required = false) String cognome, Model model) {
        List<Musicista> musicisti = new ArrayList<>(musicistaService.findAll());
        musicisti.sort(new Comparator<Musicista>() {
            @Override
            public int compare(Musicista o1, Musicista o2) {
                int votoTotale1 = albumService.sommaVoti(o1.getAlbum());
                int votoTotale2 = albumService.sommaVoti(o2.getAlbum());
                int diff = votoTotale2 - votoTotale1;
                if (diff == 0) {
                    return o1.getCognome().compareTo(o2.getCognome());
                }
                return diff;
            }
        });

        for (Musicista musicista : musicisti) {
            musicista.setVotoTotale(albumService.sommaVoti(musicista.getAlbum()));
            musicistaService.save(musicista);
        }

        if (cognome != null) {
            List<Musicista> listaNuova = new ArrayList<>();
            for (Musicista musicista : musicisti) {
                if (musicista.getCognome().equals(cognome)) {
                    listaNuova.add(musicista);
                }
            }
            if (listaNuova.isEmpty()) {
                model.addAttribute("errore", "Nessun musicista trovato con questo cognome!");
                return "classifica";
            }
            model.addAttribute("musicisti", listaNuova);
            return "classifica";
        }
        model.addAttribute("musicisti", musicisti);
        return "classifica";
    }
}