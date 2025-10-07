package com.epf.marmitax.DTO;

import java.io.IOException;

import com.epf.marmitax.models.Ingredient;

public class IngredientMapper {
    public static Ingredient fromDto(IngredientDto dto, Long id) throws IOException {
        return Ingredient.builder()
                .id_ingredient_model(id)
                .nom_ingredient_model(dto.nom_ingredient_Dto())
                .quantite_ingredient_model(dto.quantitee_ingredient_Dto())
                .build();
    }

    public static IngredientDto toDto(Ingredient ingredient){
        return IngredientDto.builder()
                .id_ingredient_Dto(ingredient.getId_ingredient_model())
                .nom_ingredient_Dto(ingredient.getNom_ingredient_model())
                .build();
    }
}