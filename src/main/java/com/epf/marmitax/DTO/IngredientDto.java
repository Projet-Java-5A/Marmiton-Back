package com.epf.marmitax.DTO;

import java.util.List;

import lombok.Builder;

@Builder
public record IngredientDto(
    Long idIngredientDto,
    String nomIngredientDto,
    CategorieSimpleDto categorieIngredientDto,
    List<RecetteDto> recettesUsingThisIngredientDto
){}
