package com.app.bookrental.bookrental.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.bookrental.bookrental.dto.ExemplaireDto;
import com.app.bookrental.bookrental.model.Exemplaire;
import com.app.bookrental.bookrental.model.Livre;
import com.app.bookrental.bookrental.repository.ExemplaireRepository;
import com.app.bookrental.bookrental.repository.LivreRepository;
import com.app.bookrental.bookrental.service.ExemplaireService;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {
    private ExemplaireRepository exemplaireRepository;
    private LivreRepository livreRepository;

    public ExemplaireServiceImpl(ExemplaireRepository exemplaireRepository, LivreRepository livreRepository){
        this.exemplaireRepository = exemplaireRepository;
        this.livreRepository = livreRepository;
    }

    @Override
    public void createExemplaire(int idLivre, ExemplaireDto exemplaireDto){
        Livre livre = livreRepository.findById(idLivre).get();
        Exemplaire exemplaire = mapToExemplaire(exemplaireDto);
        exemplaire.setLivre(livre);
        exemplaireRepository.save(exemplaire);

    }
    public List<ExemplaireDto> findAllExemplairesDto() {
        List<Exemplaire> exemplaires = exemplaireRepository.findAll();
        return exemplaires.stream().map(exemplaire -> mapToExemplaireDto(exemplaire)).collect(Collectors.toList());
    }
    
    public List<ExemplaireDto> findExemplaireDtoDispo(){
        List<ExemplaireDto> exemplaires = findAllExemplairesDto();

        return exemplaires.stream().filter(exemplaire -> exemplaire.getDisponible() == true).collect(Collectors.toList());
    }

    private Exemplaire mapToExemplaire(ExemplaireDto exemplaireDto) {
        Exemplaire exemplaire = new Exemplaire();

        exemplaire.setIdExemplaire(exemplaireDto.getIdExemplaire());
        exemplaire.setDisponible(exemplaireDto.getDisponible());

        return exemplaire;
    }

    @Override
    public List<ExemplaireDto> findAllExemplaires(int idLivre){
        List<Exemplaire> exemplaires = exemplaireRepository.findByIdLivre(idLivre);

        return exemplaires.stream().map(exemplaire -> mapToExemplaireDto(exemplaire)).collect(Collectors.toList());

    }

    private ExemplaireDto mapToExemplaireDto(Exemplaire exemplaire){
        ExemplaireDto exemplaireDto = new ExemplaireDto();

        exemplaireDto.setIdExemplaire(exemplaire.getIdExemplaire());
        exemplaireDto.setDisponible(exemplaire.getDisponible());

        if(exemplaire.getDisponible()) exemplaireDto.setViewValue("Oui");
        else exemplaireDto.setViewValue("Non");

        exemplaireDto.setTitle(exemplaire.getLivre().getTitre());
    
        return exemplaireDto;
    }

}
