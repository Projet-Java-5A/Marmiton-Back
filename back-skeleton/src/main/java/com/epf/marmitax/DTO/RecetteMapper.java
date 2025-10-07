package com.epf.marmitax.DTO;

import java.io.IOException;
import com.epf.marmitax.models.Recette;

public class RecetteMapper {
    public static Recette fromDto(RecetteDto dto, Long id) throws IOException {
        return Recette.builder()
            .id_recette_model(id)
            .nom_recette_model(dto.nom_recette_Dto())
            .ingredients_model(dto.ingredients_Dto())
            .ustensiles_model(dto.ustensiles_Dto())
            .duree_recette_model(dto.duree_recette_Dto())
            .difficulte_recette_model(dto.difficulte_recette_Dto())
            .prix_recette_model(dto.prix_recette_Dto())
            .image_recette_model(dto.image_recette_Dto())
            .build();
    }

    public static RecetteDto toDto(Recette recette){
        return RecetteDto.builder()
            .id_recette_Dto(recette.getId_recette_model())
            .nom_recette_Dto(recette.getNom_recette_model())
            .ingredients_Dto(recette.getIngredients_model())
            .ustensiles_Dto(recette.getUstensiles_model())
            .duree_recette_Dto(recette.getDuree_recette_model())
            .difficulte_recette_Dto(recette.getDifficulte_recette_model())
            .prix_recette_Dto(recette.getPrix_recette_model())
            .image_recette_Dto(recette.getImage_recette_model())
            .build();
    }
}
