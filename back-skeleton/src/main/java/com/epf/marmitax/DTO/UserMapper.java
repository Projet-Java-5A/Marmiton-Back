package com.epf.marmitax.DTO;

import java.io.IOException;

import com.epf.marmitax.models.User;

public class UserMapper {
    public static User fromDto(UserDto dto, Long id) throws IOException {
        return User.builder()
            .idUser(id)
            .isAdmin(dto.isAdminDto())
            .nomUser(dto.nomUserDto())
            .prenomUser(dto.prenomUserDto())
            .mailUser(dto.mailUserDto())
            .mdpUser(dto.mdpUserDto())
            .recettes(dto.recettesDto())
            .build();
    }

    public static UserDto toDto(User user){
        return UserDto.builder()
                .idUserDto(user.getIdUser())
                .isAdminDto(user.getIsAdmin())
                .nomUserDto(user.getNomUser())
                .prenomUserDto(user.getPrenomUser())
                .mailUserDto(user.getMailUser())
                .mdpUserDto(user.getMdpUser())
                .recettesDto(user.getRecettes())
                .build();
    }
}


