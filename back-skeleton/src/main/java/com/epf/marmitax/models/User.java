package com.epf.marmitax.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    private Long idUserModel;
    private Boolean isAdminModel;
    private String nomUserModel;
    private String prenomUserModel;
    private String mailUserModel;
    private String mdpUserModel;
    private List<Recette> recettesModel;
}