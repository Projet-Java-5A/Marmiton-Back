package com.epf.marmitax.DTO;

import lombok.Builder;

@Builder
public record UstensileDto(
    Long idUstensileDto,
    String nomUstensileDto
) 
{}
