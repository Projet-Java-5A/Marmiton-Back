package com.epf.marmitax.DTO;

import java.util.List;

import lombok.Builder;

@Builder 
public record UserDto (
    Long idUserDto,
    Boolean isAdminDto,
    String nomUserDto,
    String prenomUserDto,
    String mailUserDto,
    String mdpUserDto,
    List<RecetteDto> recettesDto
){}

