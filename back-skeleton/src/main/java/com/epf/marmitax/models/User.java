package com.epf.marmitax.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    private Long idUser;
    private Boolean isAdmin;
    private String nomUser;
    private String prenomUser;
    private String mailUser;
    private String mdpUser;
    private List<Recette> recettes;
}