package com.epf.marmitax.DTO;

import java.io.IOException;

import com.epf.marmitax.models.Ustensile;

public class UstensileMapper {
    public static Ustensile fromDto(UstensileDto dto, Long id) throws IOException {
        return Ustensile.builder()
                .id_ustensile_model(id)
                .nom_ustensile_model(dto.nom_ustensile_Dto())
                .build();
    }

    public static UstensileDto toDto(Ustensile ustensile){
        return UstensileDto.builder()
                .id_ustensile_Dto(ustensile.getId_ustensile_model())
                .build();
    }
}