package com.epf.marmitax.DTO;

import java.io.IOException;
import com.epf.marmitax.models.Recette;

public class RecetteMapper {
    public static Recette fromDto(RecetteDto dto, Long id) throws IOException {
        return Recette.builder()
            .idRecetteModel(id)
            .nomRecetteModel(dto.nomRecetteDto())
            .ingredientsModel(dto.ingredientsDto())
            .ustensilesModel(dto.ustensilesDto())
            .dureeRecetteModel(dto.dureeRecetteDto())
            .difficulteRecetteModel(dto.difficulteRecetteDto())
            .prixRecetteModel(dto.prixRecetteDto())
            .imageRecetteModel(dto.imageRecetteDto())
            .build();
    }

    public static RecetteDto toDto(Recette recette){
        return RecetteDto.builder()
            .idRecetteDto(recette.getIdRecetteModel())
            .nomRecetteDto(recette.getNomRecetteModel())
            .ingredientsDto(recette.getIngredientsModel())
            .ustensilesDto(recette.getUstensilesModel())
            .dureeRecetteDto(recette.getDureeRecetteModel())
            .difficulteRecetteDto(recette.getDifficulteRecetteModel())
            .prixRecetteDto(recette.getPrixRecetteModel())
            .imageRecetteDto(recette.getImageRecetteModel())
            .build();
    }
}
