package com.epf.marmitax.DTO;

import com.epf.marmitax.models.Ustensile;

import lombok.Builder;

import com.epf.marmitax.models.Ingredient;

import java.util.List;

@Builder
public record RecetteDto(
    Long idRecetteDto,
    String nomRecetteDto,
    String imageRecetteDto,
    Integer dureeRecetteDto,
    Integer prixRecetteDto,
    Integer difficulteRecetteDto,
    String contenuRecetteDto,
    List<Ustensile> ustensilesDto,
    List<Ingredient> ingredientsDto
){}
