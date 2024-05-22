package com.app.bookrental.bookrental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.bookrental.bookrental.dto.LivreDto;
import com.app.bookrental.bookrental.model.Livre;

@Service
public interface LivreService {
    List<Livre> findAllLivres();

    List<LivreDto> findAllLivresDto();

    Livre saveLivre(LivreDto livreDto);

    LivreDto findLivreById(int idLivre);

    void updateLivre(LivreDto livre);

    void delete(int idLivre);

}
