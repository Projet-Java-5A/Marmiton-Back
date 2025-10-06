package com.epf.marmitax.services;

import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.IngredientDao;
import com.epf.marmitax.DTO.IngredientMapper;
import com.epf.marmitax.models.Ingredient;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class IngredientService {
    private final IngredientDao ingredientDao;

    public IngredientService(IngredientDao ingredientDao){
        this.ingredientDao = ingredientDao;
    }

    // Retourner tous les ingrédients de la BDD
    public List<Ingredient> findAll() {
        Iterable<Ingredient> it = ingredientDao.findAll();
        List <Ingredient> ingredients = new ArrayList<>();
        it.forEach(ingredients::add);
        return ingredients;
    }

    // Retourner un ingredient par un Id
    public Ingredient getById(Long id){
        return ingredientDao.findById(id).orElseThrow();
    }

    // Supprimer un ingrédient par son id
    @Transactional // Réalisé par une transaction
    public void deleteById(Long id){
        ingredientDao.deleteById(id);
    }

    // Ajouter un nouvel ingrédient
    @Transactional
    public void addIngredient(IngredientDto ingredientDto){
        Ingredient ingredient;
        ingredient = IngredientMapper.fromDto(ingredientDto, null);
        ingredientDao.save(ingredient);  
    }

    // Modifier un ingrédient
    @Transactional
    public void updateIngredient(IngredientDto ingredientDto, Long id) {
        ingredientDao.findById(id).orElseThrow(() -> new NoSuchElementException("L'ingrédient n'existe pas Evannnnnnnnnnnnn"));
        Ingredient ingredient;
        ingredient = IngredientMapper.fromDto(ingredientDto, id);
        ingredientDao.save(ingredient);
    }

    // Rechercher un ingrédient par catégorie
    public List<Ingredient> searchByCategorie(int categorieId) {
        return ingredientDao.findBy(categorieId);
    }
}
