package com.epf.marmitax.services;

import com.epf.marmitax.DAO.CategorieDao;
import com.epf.marmitax.DTO.IngredientCreateDTO;
import com.epf.marmitax.DTO.IngredientListDTO;
import com.epf.marmitax.mappers.IngredientMapper;
import com.epf.marmitax.models.Categorie;
import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.IngredientDao;
import com.epf.marmitax.DTO.IngredientDto;
import com.epf.marmitax.models.Ingredient;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientDao ingredientDao;
    private final CategorieDao categorieDao;

    public IngredientService(IngredientDao ingredientDao, CategorieDao categorieDao){
        this.ingredientDao = ingredientDao;
        this.categorieDao = categorieDao;
    }

    public List<IngredientDto> findAll() {
        return ingredientDao
                .findAll()
                .stream()
                .map(IngredientMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<IngredientListDTO> findAllSimple() {
        return ingredientDao
                .findAll()
                .stream()
                .map(IngredientMapper::toListDto)
                .collect(Collectors.toList());
    }

    public IngredientDto getById(Long id){
        return ingredientDao
                .findById(id)
                .map(IngredientMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        ingredientDao.deleteById(id);
    }
 
    @Transactional
    public void addIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = IngredientMapper.fromDto(ingredientDto);
        ingredientDao.save(ingredient);  
    }

    @Transactional
    public IngredientListDTO saveIngredientFromDto(IngredientCreateDTO ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setNomIngredient(ingredientDto.getNomIngredient());
        if (ingredientDto.getIdCategorie() != null) {
            Categorie categorie = categorieDao.findById(ingredientDto.getIdCategorie().longValue())
                    .orElseThrow(() -> new NoSuchElementException("La catégorie n'existe pas"));
            ingredient.setCategorie_ingredient(categorie);
        } else {
            ingredient.setCategorie_ingredient(null);
        }
        Ingredient saved = ingredientDao.save(ingredient);
        return IngredientMapper.toListDto(saved);
    }

    @Transactional
    public void updateIngredient(Long id, IngredientCreateDTO ingredientDto) {
        Ingredient ingredient = ingredientDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("L'ingrédient avec l'ID " + id + " n'existe pas."));

        Categorie categorie = categorieDao.findById(ingredientDto.getIdCategorie().longValue())
                .orElseThrow(() -> new NoSuchElementException("La catégorie n'existe pas"));

        ingredient.setNomIngredient(ingredientDto.getNomIngredient());
        ingredient.setCategorie_ingredient(categorie);
        ingredientDao.save(ingredient);
    }
}
