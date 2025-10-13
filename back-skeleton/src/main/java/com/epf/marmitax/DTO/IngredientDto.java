package com.epf.marmitax.DTO;

import java.util.List;

import com.epf.marmitax.models.Categorie;


import lombok.Builder;

@Builder
public record IngredientDto(
    Long idIngredientDto,
    String nomIngredientDto,
    Categorie categorieIngredientDto,
    List<RecetteDto> recettesUsingThisIngredientDto
){}
