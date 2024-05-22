package com.app.bookrental.bookrental.service;

import org.springframework.stereotype.Service;

import com.app.bookrental.bookrental.dto.PretDto;
import com.app.bookrental.bookrental.model.Pret;

@Service
public interface PretService {
    Pret savePret(PretDto pretDto, int idAdherent, int idExemplaire);
}
