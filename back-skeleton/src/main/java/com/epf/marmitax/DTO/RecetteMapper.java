package com.epf.marmitax.DTO;

import java.io.IOException;
import com.epf.marmitax.models.Recette;

public class RecetteMapper {
    public static Recette fromDto(RecetteDto dto, Long id) throws IOException {
        return Recette.builder()
            .idRecette(id)
            .nomRecette(dto.nomRecetteDto())
            .ingredients(dto.ingredientsDto())
            .ustensiles(dto.ustensilesDto())
            .dureeRecette(dto.dureeRecetteDto())
            .difficulteRecette(dto.difficulteRecetteDto())
            .prixRecette(dto.prixRecetteDto())
            .imageRecette(dto.imageRecetteDto())
            .build();
    }

    public static RecetteDto toDto(Recette recette){
        return RecetteDto.builder()
            .idRecetteDto(recette.getIdRecette())
            .nomRecetteDto(recette.getNomRecette())
            .ingredientsDto(recette.getIngredients())
            .ustensilesDto(recette.getUstensiles())
            .dureeRecetteDto(recette.getDureeRecette())
            .difficulteRecetteDto(recette.getDifficulteRecette())
            .prixRecetteDto(recette.getPrixRecette())
            .imageRecetteDto(recette.getImageRecette())
            .build();
    }
}
