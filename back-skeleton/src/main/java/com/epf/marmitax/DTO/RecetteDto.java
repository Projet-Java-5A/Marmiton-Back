package com.epf.marmitax.DTO;

import com.epf.marmitax.models.Ustensile;
import com.epf.marmitax.models.Ingredient;

import java.util.List;

public record RecetteDto(
    Long id_recette_Dto,
    String nom_recette_Dto,
    String image_recette_Dto,
    Integer duree_recette_Dto,
    Integer prix_recette_Dto,
    Integer difficulté_recette_Dto,
    String contenu_recette_Dto,
    List<Ustensile> ustensiles_Dto,
    List<Ingredient> ingredients_Dto
){}
