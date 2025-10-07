package com.epf.marmitax.DTO;

import com.epf.marmitax.models.Ustensile;

public class UstensileMapper {
    public static Ustensile fromDto(UstensileDto dto) {
        return Ustensile.builder()
                .idUstensile(dto.idUstensileDto())
                .nomUstensile(dto.nomUstensileDto())
                .build();
    }

    public static UstensileDto toDto(Ustensile ustensile){
        return UstensileDto.builder()
                .idUstensileDto(ustensile.getIdUstensile())
                .build();
    }
}