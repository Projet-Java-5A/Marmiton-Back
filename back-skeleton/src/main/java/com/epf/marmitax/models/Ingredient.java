package com.epf.marmitax.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Ingredient {
    private Long id_ingredient_model;
    private String nom_ingredient_model;
    private String quantite_ingredient_model;
}
