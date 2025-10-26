package com.epf.marmitax.DTO;

import lombok.Builder;

@Builder
public record IngredientDetailsDto(
    Long id,
    String nom,
    CategorieSimpleDto categorie,
    String quantite
) {
}
