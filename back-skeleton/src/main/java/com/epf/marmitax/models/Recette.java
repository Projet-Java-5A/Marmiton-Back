package com.epf.marmitax.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Recette {
    private Long id_recette_model;
    private String nom_recette_model;
    private List<Ingredient> ingredients_model;
    private List<Ustensile> ustensiles_model;
    private Integer duree_recette_model;
    private Integer difficulte_recette_model;
    private Integer prix_recette_model;
    private String image_recette_model;
}
