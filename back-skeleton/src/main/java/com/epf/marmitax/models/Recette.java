package com.epf.marmitax.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Recette {
    private Long idRecette;
    private String nomRecette;
    private List<Ingredient> ingredients;
    private List<Ustensile> ustensiles;
    private Integer dureeRecette;
    private Integer difficulteRecette;
    private Integer prixRecette;
    private String imageRecette;
    private String contenuRecette; 
}
