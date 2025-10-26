package com.epf.marmitax.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientListDTO {
    @JsonProperty("id_ingredient")
    private int idIngredient;
    @JsonProperty("nom_ingredient")
    private String nomIngredient;
    @JsonProperty("id_categorie")
    private int idCategorie;
}
