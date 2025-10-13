package com.epf.marmitax.DTO;

import com.epf.marmitax.models.Categorie;

public class CategorieMapper {
    public static Categorie fromDto(CategorieDto dto) {
        return Categorie.builder()
                .idCategorie(dto.idCategorieDto())
                .nomCategorie(dto.nomCategorieDto())
                .build();
    }

    public static CategorieDto toDto(Categorie categorie){
        return CategorieDto.builder()
                .idCategorieDto(categorie.getIdCategorie())
                .nomCategorieDto(categorie.getNomCategorie())
                .build();
    }
}
