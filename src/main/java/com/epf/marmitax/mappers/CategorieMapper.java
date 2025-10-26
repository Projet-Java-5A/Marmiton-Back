package com.epf.marmitax.mappers;

import com.epf.marmitax.DTO.CategorieSimpleDto;
import com.epf.marmitax.models.Categorie;

public class CategorieMapper {
    public static Categorie fromDto(CategorieSimpleDto dto) {
        return Categorie.builder()
                .idCategorie(dto.idCategorieDto())
                .nomCategorie(dto.nomCategorieDto())
                .build();
    }

    public static CategorieSimpleDto toDto(Categorie categorie){
        return CategorieSimpleDto.builder()
                .idCategorieDto(categorie.getIdCategorie())
                .nomCategorieDto(categorie.getNomCategorie())
                .build();
    }
}
