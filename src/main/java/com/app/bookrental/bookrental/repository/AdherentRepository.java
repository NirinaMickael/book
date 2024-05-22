package com.app.bookrental.bookrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.bookrental.bookrental.model.Adherent;


public interface AdherentRepository extends JpaRepository<Adherent, Integer> {  

}
