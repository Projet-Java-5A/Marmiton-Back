package com.epf.marmitax.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecetteIngredientId implements Serializable {

    @Column(name = "id_recette")
    private Long idRecette;

    @Column(name = "id_ingredient")
    private Long idIngredient;

    public RecetteIngredientId() {}

    public RecetteIngredientId(Long idRecette, Long idIngredient) {
        this.idRecette = idRecette;
        this.idIngredient = idIngredient;
    }

    public Long getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(Long idRecette) {
        this.idRecette = idRecette;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecetteIngredientId that = (RecetteIngredientId) o;
        return Objects.equals(idRecette, that.idRecette) &&
               Objects.equals(idIngredient, that.idIngredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecette, idIngredient);
    }
}
