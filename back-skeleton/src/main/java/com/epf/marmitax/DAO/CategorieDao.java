package com.epf.marmitax.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epf.marmitax.models.Categorie;

@Repository
public interface CategorieDao extends JpaRepository<Categorie, Long> {

}