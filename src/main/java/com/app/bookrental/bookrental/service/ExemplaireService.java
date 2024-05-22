package com.app.bookrental.bookrental.service;

import java.util.List;

import com.app.bookrental.bookrental.dto.ExemplaireDto;


public interface ExemplaireService {
    void createExemplaire(int idLivre, ExemplaireDto exemplaireDto);
    public List<ExemplaireDto>  findAllExemplaires(int idLivre);
    public List<ExemplaireDto> findAllExemplairesDto();
    public List<ExemplaireDto> findExemplaireDtoDispo();
}
