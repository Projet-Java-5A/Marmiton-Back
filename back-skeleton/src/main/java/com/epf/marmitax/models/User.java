package com.epf.marmitax.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    private Long id_user_model;
    private Boolean isAdmin_model;
    private String nom_user_model;
    private String prenom_user_model;
    private String mail_user_model;
    private String mdp_user_model;
    private List<Recette> recettes_model;
}