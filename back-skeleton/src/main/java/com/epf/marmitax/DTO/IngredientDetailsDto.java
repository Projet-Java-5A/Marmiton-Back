package com.epf.marmitax.DTO;

import com.epf.marmitax.models.Categorie;
import lombok.Builder;

@Builder
public record IngredientDetailsDto(
    Long id,
    String nom,
    CategorieDto categorie,
    String quantite
) {
}
