package com.epf.marmitax.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Categorie {
    private Long id_categorie_model;
    private String nom_categorie_model;
}
