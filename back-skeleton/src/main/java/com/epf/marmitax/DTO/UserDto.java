package com.epf.marmitax.DTO;

import java.util.List;

import com.epf.marmitax.models.Recette;

import lombok.Builder;

@Builder 
public record UserDto (
    Long id_user_Dto,
    Boolean isAdmin_Dto,
    String nom_user_Dto,
    String prenom_user_Dto,
    String mail_user_Dto,
    String mdp_user_Dto,
    List<Recette> recettes_Dto
){}

