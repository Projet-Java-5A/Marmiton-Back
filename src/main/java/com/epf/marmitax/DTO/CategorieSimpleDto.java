package com.epf.marmitax.DTO;

import lombok.Builder;

@Builder
public record CategorieSimpleDto(
    Long idCategorieDto,
    String nomCategorieDto
) {}