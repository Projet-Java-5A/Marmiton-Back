package com.epf.marmitax.DTO;

import lombok.Builder;

import java.util.List;

@Builder
public record RecetteDto(
    Long idRecetteDto,
    String nomRecetteDto,
    List<IngredientDto> ingredientsDto,
    List<UstensileDto> ustensilesDto,
    Integer dureeRecetteDto,
    Integer difficulteRecetteDto,
    Integer prixRecetteDto,
    String imageRecetteDto,
    String contenuRecetteDto
){}
