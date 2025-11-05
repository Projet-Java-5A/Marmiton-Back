package com.epf.marmitax.mappers;


import com.epf.marmitax.DTO.CategorieDto;
import com.epf.marmitax.DTO.CategorieSimpleDto;
import com.epf.marmitax.models.Categorie;

public class CategorieMapper {
    public static Categorie fromDto(CategorieSimpleDto dto) {
        return Categorie.builder()
                .idCategorie(dto.idCategorieDto())
                .nomCategorie(dto.nomCategorieDto())
                .build();
    }

    public static CategorieSimpleDto toSimpleDto(Categorie categorie){
        if (categorie == null) {
            return new CategorieSimpleDto(0L, "");
        }
        return CategorieSimpleDto.builder()
                .idCategorieDto(categorie.getIdCategorie())
                .nomCategorieDto(categorie.getNomCategorie())
                .build();
    }

    public static Categorie fromDto(CategorieDto dto) {
        return Categorie.builder()
                .idCategorie(dto.idCategorieDto())
                .nomCategorie(dto.nomCategorieDto())
                .ingredientsDansCategorie(dto.ingredientsDansCategorieDto().stream().map(IngredientMapper::fromDto).toList())
                .build();
    }

    public static CategorieDto toDto(Categorie categorie){
        return CategorieDto.builder()
                .idCategorieDto(categorie.getIdCategorie())
                .nomCategorieDto(categorie.getNomCategorie())
                .ingredientsDansCategorieDto(categorie.getIngredientsDansCategorie().stream().map(IngredientMapper::toIngredientDansCategorieDto).toList())
                .build();
    }
}
