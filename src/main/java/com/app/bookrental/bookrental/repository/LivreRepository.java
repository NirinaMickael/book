package com.app.bookrental.bookrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.bookrental.bookrental.model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer> {
    Livre findByIdLivre(int idLivre);

    Livre findByTitre(String titre);
}
