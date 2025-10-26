package com.epf.marmitax.mappers;

import java.util.ArrayList;

import com.epf.marmitax.DTO.IngredientDansCategorieDto;
import com.epf.marmitax.DTO.IngredientDto;
import com.epf.marmitax.DTO.IngredientListDTO;
import com.epf.marmitax.models.Ingredient;

public class IngredientMapper {
    public static Ingredient fromDto(IngredientDto dto) {
        return Ingredient.builder()
                .idIngredient(dto.idIngredientDto())
                .nomIngredient(dto.nomIngredientDto())
                .categorie_ingredient(CategorieMapper.fromDto(dto.categorieIngredientDto()))
                // .recettesUsingThisIngredient(dto.recettesUsingThisIngredientDto().stream().map(RecetteMapper::fromDto).collect(Collectors.toList()))
                .build();
    }

    public static IngredientDto toDto(Ingredient ingredient){
        return IngredientDto.builder()
                .idIngredientDto(ingredient.getIdIngredient())
                .nomIngredientDto(ingredient.getNomIngredient())
                .categorieIngredientDto(CategorieMapper.toSimpleDto(ingredient.getCategorie_ingredient()))
                .recettesUsingThisIngredientDto(new ArrayList<>()) // Empty list
                .build();
    }

    public static IngredientListDTO toListDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }

        return new IngredientListDTO(
                ingredient.getIdIngredient().intValue(),
                ingredient.getNomIngredient(),
                ingredient.getCategorie_ingredient() != null ? ingredient.getCategorie_ingredient().getIdCategorie().intValue() : 0
        );
    }

    public static Ingredient fromDto(IngredientDansCategorieDto dto) {
        return Ingredient.builder()
                .idIngredient(dto.idIngredientDto())
                .nomIngredient(dto.nomIngredientDto())
                .build();
    }

    public static IngredientDansCategorieDto toIngredientDansCategorieDto(Ingredient ingredient){
        return IngredientDansCategorieDto.builder()
                .idIngredientDto(ingredient.getIdIngredient())
                .nomIngredientDto(ingredient.getNomIngredient())
                .build();
    }


}
        