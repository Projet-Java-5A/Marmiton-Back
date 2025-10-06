package com.epf.marmitax.DTO;

import lombok.Builder;

@Builder
public record IngrediantDto(
    Long id_ingredient_Dto,
    String nom_ingredient_Dto,
    String quantite_ingredient_Dto
){}
