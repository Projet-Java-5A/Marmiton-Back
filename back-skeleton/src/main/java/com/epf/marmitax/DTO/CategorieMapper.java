package com.epf.marmitax.DTO;

import java.io.IOException;

import com.epf.marmitax.models.Categorie;

public class CategorieMapper {
    public static Categorie fromDto(CategorieDto dto, Long id) throws IOException {
        return Categorie.builder()
                .idCategorieModel(id)
                .nomCategorieModel(dto.nomCategorieDto())
                .build();
    }

    public static CategorieDto toDto(Categorie categorie){
        return CategorieDto.builder()
                .idCategorieDto(categorie.getIdCategorieModel())
                .build();
    }
}
