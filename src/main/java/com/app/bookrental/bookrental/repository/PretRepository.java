package com.app.bookrental.bookrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.bookrental.bookrental.model.Pret;



public interface PretRepository extends JpaRepository<Pret, Integer> {

}
