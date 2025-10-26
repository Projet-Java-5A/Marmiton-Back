package com.epf.marmitax.mappers;

import com.epf.marmitax.DTO.IngredientListDTO;
import com.epf.marmitax.models.Ingredient;

public class IngredientListMapper {
    public static IngredientListDTO toDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }

        return new IngredientListDTO(
                ingredient.getIdIngredient().intValue(),
                ingredient.getNomIngredient(),
                ingredient.getCategorie_ingredient() != null ? ingredient.getCategorie_ingredient().getIdCategorie().intValue() : 0
        );
    }
}
