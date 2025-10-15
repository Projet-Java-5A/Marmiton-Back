package com.epf.marmitax.services;

import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.IngredientDao;
import com.epf.marmitax.DTO.IngredientMapper;
import com.epf.marmitax.DTO.IngredientDto;
import com.epf.marmitax.models.Ingredient;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientDao ingredientDao;

    public IngredientService(IngredientDao ingredientDao){
        this.ingredientDao = ingredientDao;
    }

    public List<IngredientDto> findAll() {
        return ingredientDao
                .findAll()
                .stream()
                .map(IngredientMapper::toDto)
                .collect(Collectors.toList());
    }

    public IngredientDto getById(Long id){
        return ingredientDao
                .findById(id)
                .map(IngredientMapper::toDto)
                .orElseThrow();
    }

    @Transactional // Réalisé par une transaction
    public void deleteById(Long id){
        ingredientDao.deleteById(id);
    }
 
    @Transactional
    public void addIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = IngredientMapper.fromDto(ingredientDto);
        ingredientDao.save(ingredient);  
    }

    @Transactional
    public void updateIngredient(IngredientDto ingredientDto) {
        ingredientDao.findById(ingredientDto.idIngredientDto()).orElseThrow(() -> new NoSuchElementException("L'ingrédient n'existe pas Evannnnnnnnnnnnn"));
        Ingredient ingredient;
        ingredient = IngredientMapper.fromDto(ingredientDto);
        ingredientDao.save(ingredient);
    }

    // TODO Rechercher un ingrédient par catégorie
//    public List<Ingredient> searchByCategorie(int categorieId) {
//        return ingredientDao.findAllByCategorie_ingredientEquals(categorieId);
//    }
}
