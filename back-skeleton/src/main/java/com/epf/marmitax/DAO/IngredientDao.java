package com.epf.marmitax.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epf.marmitax.models.Ingredient;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Long> {
    
}


