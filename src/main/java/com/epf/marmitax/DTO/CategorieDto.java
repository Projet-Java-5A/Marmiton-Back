package com.epf.marmitax.DTO;

import java.util.List;

import lombok.Builder;

@Builder
public record CategorieDto(
    Long idCategorieDto,
    String nomCategorieDto,
    List<IngredientDto> ingredientsDansCategorieDto
) {}
