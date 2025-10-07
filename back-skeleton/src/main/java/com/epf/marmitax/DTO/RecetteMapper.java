package com.epf.marmitax.DTO;

import java.util.stream.Collectors;

import com.epf.marmitax.models.Recette;

public class RecetteMapper {
    public static Recette fromDto(RecetteDto dto) {
        return Recette.builder()
            .idRecette(dto.idRecetteDto())
            .nomRecette(dto.nomRecetteDto())
            .ingredients(dto.ingredientsDto().stream().map(IngredientMapper::fromDto).collect(Collectors.toList()))
            .ustensiles(dto.ustensilesDto().stream().map(UstensileMapper::fromDto).collect(Collectors.toList()))
            .dureeRecette(dto.dureeRecetteDto())
            .difficulteRecette(dto.difficulteRecetteDto())
            .prixRecette(dto.prixRecetteDto())
            .imageRecette(dto.imageRecetteDto())
            .contenuRecette(dto.contenuRecetteDto())
            .build();
    }

    public static RecetteDto toDto(Recette recette){
        return RecetteDto.builder()
            .idRecetteDto(recette.getIdRecette())
            .nomRecetteDto(recette.getNomRecette())
            .ingredientsDto(recette.getIngredients().stream().map(IngredientMapper::toDto).collect(Collectors.toList()))
            .ustensilesDto(recette.getUstensiles().stream().map(UstensileMapper::toDto).collect(Collectors.toList()))
            .dureeRecetteDto(recette.getDureeRecette())
            .difficulteRecetteDto(recette.getDifficulteRecette())
            .prixRecetteDto(recette.getPrixRecette())
            .imageRecetteDto(recette.getImageRecette())
            .contenuRecetteDto(recette.getContenuRecette())
            .build();
    }
}
