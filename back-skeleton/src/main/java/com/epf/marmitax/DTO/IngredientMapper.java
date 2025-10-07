package com.epf.marmitax.DTO;

import java.io.IOException;

import com.epf.marmitax.models.Ingredient;

public class IngredientMapper {
    public static Ingredient fromDto(IngredientDto dto, Long id) throws IOException {
        return Ingredient.builder()
                .idIngredientModel(id)
                .nomIngredientModel(dto.nomIngredientDto())
                .quantiteIngredientModel(dto.quantiteeIngredientDto())
                .build();
    }

    public static IngredientDto toDto(Ingredient ingredient){
        return IngredientDto.builder()
                .idIngredientDto(ingredient.getIdIngredientModel())
                .nomIngredientDto(ingredient.getNomIngredientModel())
                .build();
    }
}