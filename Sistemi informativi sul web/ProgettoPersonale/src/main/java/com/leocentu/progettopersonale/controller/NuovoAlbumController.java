package com.leocentu.progettopersonale.controller;

import com.leocentu.progettopersonale.model.Album;
import com.leocentu.progettopersonale.model.Musicista;
import com.leocentu.progettopersonale.service.AlbumService;
import com.leocentu.progettopersonale.service.MusicistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequestMapping("/musicista")
@Controller
public class NuovoAlbumController {
    @Autowired
    private MusicistaService musicistaService;
    @Autowired
    private AlbumService albumService;

    @GetMapping("/nuovoAlbum")
    public String nuovoAlbum(@RequestParam("username") String username, Model model) {
        Musicista musicista = musicistaService.findByCredenzialiUsername(username);
        model.addAttribute("musicistaId", musicista.getId());
        return "nuovoAlbum";
    }

    @PostMapping("/albumAggiunto")
    public String albumAggiunto(@RequestParam("titolo") String titolo,
                                 @RequestParam("testo") String testo,
                                 @RequestParam("musicistaId") Long musicistaId,
                                 RedirectAttributes redirectAttributes) {
        Album album = new Album();
        Musicista musicista = musicistaService.findById(musicistaId);
        album.setTitolo(titolo);
        album.setTesto(testo);
        album.setVoto(0);
        album.setMusicista(musicista);
        musicista.getAlbum().add(album);
        albumService.save(album);
        redirectAttributes.addFlashAttribute("albumAggiunto", "Album aggiunto con successo!");
        return "redirect:/";
    }
}