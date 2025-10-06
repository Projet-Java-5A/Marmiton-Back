package com.epf.marmitax.DTO;

import lombok.Builder;

@Builder
public record UstensileDto(
    Long id_ustensile_Dto,
    String nom_ustensile_Dto
) 
{}
