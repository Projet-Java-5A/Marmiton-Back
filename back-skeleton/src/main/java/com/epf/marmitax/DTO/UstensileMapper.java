package com.epf.marmitax.DTO;

import java.io.IOException;

import com.epf.marmitax.models.Ustensile;

public class UstensileMapper {
    public static Ustensile fromDto(UstensileDto dto, Long id) throws IOException {
        return Ustensile.builder()
                .idUstensileModel(id)
                .nomUstensileModel(dto.nomUstensileDto())
                .build();
    }

    public static UstensileDto toDto(Ustensile ustensile){
        return UstensileDto.builder()
                .idUstensileDto(ustensile.getIdUstensileModel())
                .build();
    }
}