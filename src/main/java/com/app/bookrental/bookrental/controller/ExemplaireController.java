package com.app.bookrental.bookrental.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.bookrental.bookrental.dto.ExemplaireDto;
import com.app.bookrental.bookrental.dto.LivreDto;
import com.app.bookrental.bookrental.model.Exemplaire;
import com.app.bookrental.bookrental.service.ExemplaireService;
import com.app.bookrental.bookrental.service.LivreService;

@Controller
public class ExemplaireController {
    private ExemplaireService exemplaireService;
    private LivreService livreService;

    public ExemplaireController(ExemplaireService exemplaireService, LivreService livreService) {
        this.exemplaireService = exemplaireService;
        this.livreService = livreService;
    }

    /* @GetMapping("/exemplaires")
    public String listExemplaires(Model model) {
        List<ExemplaireDto> exemplaires = exemplaireService.findAll();
        return "exemplaires-list";
    } */

    @GetMapping("/exemplaires/{idLivre}/new")
    public String createExemplaireForm(@PathVariable("idLivre") int idLivre, Model model) {
        Exemplaire examplaire = new Exemplaire();
        model.addAttribute("exemplaire", examplaire);
        model.addAttribute("idLivre", idLivre);
        return "exemplaire-create";
    }

    @PostMapping("/exemplaires/{idLivre}/new")
    public String createExemplaire(@PathVariable("idLivre") int idLivre, @ModelAttribute("exemplaire") ExemplaireDto exemplaireDto, Model model ){
        exemplaireService.createExemplaire(idLivre, exemplaireDto);
        
        return "redirect:/livres";
    }

    @GetMapping("/exemplaires/{idLivre}/view")
    public String listExemplairePerIdLivre(@PathVariable("idLivre") int idLivre, Model model){
        List<ExemplaireDto> exemplaires = exemplaireService.findAllExemplaires(idLivre);
        LivreDto livreCorrespondant = livreService.findLivreById(idLivre);
        String title = livreCorrespondant.getTitre();

        model.addAttribute("exemplaires", exemplaires);
        model.addAttribute("titre", title);
        return "exemplaires-view";
    }
}
