package com.epf.marmitax.mappers;

import java.util.ArrayList;

import com.epf.marmitax.DTO.IngredientDto;
import com.epf.marmitax.models.Ingredient;

public class IngredientMapper {
    public static Ingredient fromDto(IngredientDto dto) {
        return Ingredient.builder()
                .idIngredient(dto.idIngredientDto())
                .nomIngredient(dto.nomIngredientDto())
                .categorie_ingredient(dto.categorieIngredientDto())
                // .recettesUsingThisIngredient(dto.recettesUsingThisIngredientDto().stream().map(RecetteMapper::fromDto).collect(Collectors.toList()))
                .build();
    }

    public static IngredientDto toDto(Ingredient ingredient){
        return IngredientDto.builder()
                .idIngredientDto(ingredient.getIdIngredient())
                .nomIngredientDto(ingredient.getNomIngredient())
                .categorieIngredientDto(ingredient.getCategorie_ingredient())
                .recettesUsingThisIngredientDto(new ArrayList<>()) // Empty list
                .build();
    }
}