package com.epf.marmitax.DTO;

import lombok.Builder;

@Builder
public record CategorieDto(
    Long idCategorieDto,
    String nomCategorieDto
) {}