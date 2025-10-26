package com.epf.marmitax.DTO;

import lombok.Builder;

@Builder
public record IngredientDansCategorieDto(
    Long idIngredientDto,
    String nomIngredientDto
){}
