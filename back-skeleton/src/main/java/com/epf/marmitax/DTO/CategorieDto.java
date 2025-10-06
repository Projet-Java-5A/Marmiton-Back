package com.epf.marmitax.DTO;

import lombok.Builder;

@Builder
public record CategorieDto(
    Long id_categorie_Dto,
    String nom_categorie_Dto
) {}