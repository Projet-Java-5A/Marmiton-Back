package com.epf.marmitax.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Recette {
    private Long idRecetteModel;
    private String nomRecetteModel;
    private List<Ingredient> ingredientsModel;
    private List<Ustensile> ustensilesModel;
    private Integer dureeRecetteModel;
    private Integer difficulteRecetteModel;
    private Integer prixRecetteModel;
    private String imageRecetteModel;
    private String contenuRecetteModel; 
}
