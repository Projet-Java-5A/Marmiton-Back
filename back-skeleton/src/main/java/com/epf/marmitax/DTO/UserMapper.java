package com.epf.marmitax.DTO;

import java.io.IOException;

import com.epf.marmitax.models.User;

public class UserMapper {
    public static User fromDto(UserDto dto, Long id) throws IOException {
        return User.builder()
            .id_user_model(id)
            .isAdmin_model(dto.isAdmin_Dto())
            .nom_user_model(dto.nom_user_Dto())
            .prenom_user_model(dto.prenom_user_Dto())
            .mail_user_model(dto.mail_user_Dto())
            .mdp_user_model(dto.mdp_user_Dto())
            .recettes_model(dto.recettes_Dto())
            .build();
    }

    public static UserDto toDto(User user){
        return UserDto.builder()
                .id_user_Dto(user.getId_user_model())
                .isAdmin_Dto(user.getIsAdmin_model())
                .nom_user_Dto(user.getNom_user_model())
                .prenom_user_Dto(user.getPrenom_user_model())
                .mail_user_Dto(user.getMail_user_model())
                .mdp_user_Dto(user.getMdp_user_model())
                .recettes_Dto(user.getRecettes_model())
                .build();
    }
}


