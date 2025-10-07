package com.epf.marmitax.DTO;

import java.io.IOException;

import com.epf.marmitax.models.User;

public class UserMapper {
    public static User fromDto(UserDto dto, Long id) throws IOException {
        return User.builder()
            .idUserModel(id)
            .isAdminModel(dto.isAdminDto())
            .nomUserModel(dto.nomUserDto())
            .prenomUserModel(dto.prenomUserDto())
            .mailUserModel(dto.mailUserDto())
            .mdpUserModel(dto.mdpUserDto())
            .recettesModel(dto.recettesDto())
            .build();
    }

    public static UserDto toDto(User user){
        return UserDto.builder()
                .idUserDto(user.getIdUserModel())
                .isAdminDto(user.getIsAdminModel())
                .nomUserDto(user.getNomUserModel())
                .prenomUserDto(user.getPrenomUserModel())
                .mailUserDto(user.getMailUserModel())
                .mdpUserDto(user.getMdpUserModel())
                .recettesDto(user.getRecettesModel())
                .build();
    }
}


