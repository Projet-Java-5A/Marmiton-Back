package com.epf.marmitax.DTO;

import java.io.IOException;

import com.epf.marmitax.models.Categorie;

public class CategorieMapper {
    public static Categorie fromDto(CategorieDto dto, Long id) throws IOException {
        return Categorie.builder()
                .id_categorie_model(id)
                .nom_categorie_model(dto.nom_categorie_Dto())
                .build();
    }

    public static CategorieDto toDto(Categorie categorie){
        return CategorieDto.builder()
                .id_categorie_Dto(categorie.getId_categorie_model())
                .build();
    }
}
