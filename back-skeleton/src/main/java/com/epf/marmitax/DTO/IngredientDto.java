package com.epf.marmitax.DTO;

import com.epf.marmitax.models.Categorie;


import lombok.Builder;

@Builder
public record IngredientDto(
    Long id_ingredient_Dto,
    String nom_ingredient_Dto,
    String quantitee_ingredient_Dto,
    Categorie categorie_Dto
){}
