package com.epf.marmitax.DTO;

import lombok.Data;
import java.util.List;

@Data
public class RecetteCreateDTO {
    private String nomRecette;
    private List<IngredientQuantiteDTO> ingredients;
    private List<Long> ustensilesIds;
    private String imageRecette;
    private String contenuRecette;
    private double prixRecette;
    private int difficulteRecette;
    private int dureeRecette;
    private Long utilisateurId;
}
