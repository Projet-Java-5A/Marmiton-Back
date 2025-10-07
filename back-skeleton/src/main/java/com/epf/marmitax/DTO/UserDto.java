package com.epf.marmitax.DTO;

import java.util.List;

import com.epf.marmitax.models.Recette;

import lombok.Builder;

@Builder 
public record UserDto (
    Long idUserDto,
    Boolean isAdminDto,
    String nomUserDto,
    String prenomUserDto,
    String mailUserDto,
    String mdpUserDto,
    List<Recette> recettesDto
){}

