package com.app.bookrental.bookrental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.bookrental.bookrental.dto.AdherentDto;
import com.app.bookrental.bookrental.model.Adherent;



@Service
public interface AdherentService {
    List<Adherent> findAllAdherents();

    List<AdherentDto> findAllAdherentDtos();
      
    

    Adherent saveAdherent(AdherentDto adherentDto);

    AdherentDto findAdherentById(int idAdherent);

    void updateAdherent(AdherentDto adherent);

    void delete(int idLivre);
}
