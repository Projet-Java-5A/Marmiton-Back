package com.epf.marmitax.mappers;

import java.util.stream.Collectors;

import com.epf.marmitax.DTO.IngredientDetailsDto;
import com.epf.marmitax.DTO.RecetteDto;
import com.epf.marmitax.models.Ingredient;
import com.epf.marmitax.models.Recette;

public class RecetteMapper {
    public static Recette fromDto(RecetteDto dto) {
        return Recette.builder()
            .idRecette(dto.idRecetteDto())
            .nomRecette(dto.nomRecetteDto())
            // .ingredients(dto.ingredientsDto().stream().map(IngredientMapper::fromDto).collect(Collectors.toList()))
            .ustensiles(dto.ustensilesDto().stream().map(UstensileMapper::fromDto).collect(Collectors.toList()))
            .dureeRecette(dto.dureeRecetteDto())
            .difficulteRecette(dto.difficulteRecetteDto())
            .prixRecette(dto.prixRecetteDto())
            .imageRecette(dto.imageRecetteDto())
            .contenuRecette(dto.contenuRecetteDto())
            .approvalStatus(dto.approvalStatus())
            .build();
    }

    public static RecetteDto toDto(Recette recette){
        return RecetteDto.builder()
            .idRecetteDto(recette.getIdRecette())
            .nomRecetteDto(recette.getNomRecette())
            .ingredientsDto(recette.getRecetteIngredients().stream().map(recetteIngredient -> {
                Ingredient ingredient = recetteIngredient.getIngredient();
                return IngredientDetailsDto.builder()
                    .id(ingredient.getIdIngredient())
                    .nom(ingredient.getNomIngredient())
                    .categorie(CategorieMapper.toSimpleDto(ingredient.getCategorie_ingredient()))
                    .quantite(recetteIngredient.getQuantite())
                    .build();
            }).collect(Collectors.toList()))
            .ustensilesDto(recette.getUstensiles().stream().map(UstensileMapper::toDto).collect(Collectors.toList()))
            .dureeRecetteDto(recette.getDureeRecette())
            .difficulteRecetteDto(recette.getDifficulteRecette())
            .prixRecetteDto(recette.getPrixRecette())
            .imageRecetteDto(recette.getImageRecette())
            .contenuRecetteDto(recette.getContenuRecette())
            .approvalStatus(recette.getApprovalStatus())
            .nomAuteur(recette.getUtilisateurs().getNomUser())
            .prenomAuteur(recette.getUtilisateurs().getPrenomUser())
            .build();
    }

    public static void updateFromDto(RecetteDto dto, Recette recette) {
        recette.setNomRecette(dto.nomRecetteDto());
        recette.setDureeRecette(dto.dureeRecetteDto());
        recette.setDifficulteRecette(dto.difficulteRecetteDto());
        recette.setPrixRecette(dto.prixRecetteDto());
        recette.setImageRecette(dto.imageRecetteDto());
        recette.setContenuRecette(dto.contenuRecetteDto());
        // Note: La gestion des listes (ingrédients, ustensiles) est plus complexe
        // et n'est pas incluse ici. Elle nécessite une logique de synchronisation.
    }
}
