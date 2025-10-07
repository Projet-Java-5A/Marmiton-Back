package com.epf.marmitax.DTO;

import com.epf.marmitax.models.Categorie;


import lombok.Builder;

@Builder
public record IngredientDto(
    Long idIngredientDto,
    String nomIngredientDto,
    String quantiteeIngredientDto,
    Categorie categorieDto
){}
