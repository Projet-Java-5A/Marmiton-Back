package com.epf.marmitax.DTO;

import lombok.Data;

@Data
public class UserCreateDTO {
    private boolean isAdmin;
    private String nomUser;
    private String prenomUser;
    private String mailUser;
    private String mdpUser;
}
