package com.epf.marmitax.DTO;

import java.util.stream.Collectors;

import com.epf.marmitax.models.Ingredient;

public class IngredientMapper {
    public static Ingredient fromDto(IngredientDto dto) {
        return Ingredient.builder()
                .idIngredient(dto.idIngredientDto())
                .nomIngredient(dto.nomIngredientDto())
                .quantiteIngredient(dto.quantiteeIngredientDto())
                .categorie_ingredient(dto.categorieIngredientDto())
                .recettesUsingThisIngredient(dto.recettesUsingThisIngredientDto().stream().map(RecetteMapper::fromDto).collect(Collectors.toList()))
                .build();
    }

    public static IngredientDto toDto(Ingredient ingredient){
        return IngredientDto.builder()
                .idIngredientDto(ingredient.getIdIngredient())
                .nomIngredientDto(ingredient.getNomIngredient())
                .quantiteeIngredientDto(ingredient.getQuantiteIngredient())
                .categorieIngredientDto(ingredient.getCategorie_ingredient())
                .recettesUsingThisIngredientDto(ingredient.getRecettesUsingThisIngredient().stream().map(RecetteMapper::toDto).collect(Collectors.toList()))
                .build();
    }
}