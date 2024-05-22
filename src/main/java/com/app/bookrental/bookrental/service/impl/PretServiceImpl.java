package com.app.bookrental.bookrental.service.impl;

import org.springframework.stereotype.Service;

import com.app.bookrental.bookrental.dto.PretDto;
import com.app.bookrental.bookrental.model.Adherent;
import com.app.bookrental.bookrental.model.Exemplaire;
import com.app.bookrental.bookrental.model.Pret;
import com.app.bookrental.bookrental.repository.AdherentRepository;
import com.app.bookrental.bookrental.repository.ExemplaireRepository;
import com.app.bookrental.bookrental.repository.PretRepository;
import com.app.bookrental.bookrental.service.PretService;

@Service
public class PretServiceImpl implements PretService{
    private PretRepository pretRepository;
    private AdherentRepository adherentRepository;
    private ExemplaireRepository exemplaireRepository;


    public PretServiceImpl(PretRepository pretRepository,AdherentRepository adherentRepository, ExemplaireRepository exemplaireRepository){
        this.pretRepository = pretRepository;
        this.adherentRepository = adherentRepository;
        this.exemplaireRepository = exemplaireRepository;
    }
    
    @Override
    public Pret savePret(PretDto pretDto, int idAdherent, int idExemplaire) {
        Pret pret = mapToPret(pretDto);
        Adherent adherent = adherentRepository.findById(idAdherent).get();
        Exemplaire exemplaire = exemplaireRepository.findById(idExemplaire).get();
        pret.setAdherent(adherent);
        pret.setExemplaire(exemplaire);
        pretRepository.save(pret);

        return pret;
    }

    private Pret mapToPret(PretDto pretDto) {
        Pret pret = new Pret();

        pret.setIdPret(pretDto.getIdPret());
        pret.setDatePret(pretDto.getDatePret());
        pret.setDateRemise(pretDto.getDateRemise());

        return pret;
    }
}   
