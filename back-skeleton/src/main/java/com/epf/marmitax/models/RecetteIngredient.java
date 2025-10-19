package com.epf.marmitax.models;

import jakarta.persistence.*;

@Entity
@Table(name = "recette_ingredient")
public class RecetteIngredient {

    @EmbeddedId
    private RecetteIngredientId id = new RecetteIngredientId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idRecette")
    @JoinColumn(name = "id_recette")
    private Recette recette;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredient")
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;

    @Column(name = "quantite")
    private String quantite;

    public RecetteIngredient() {}

    public RecetteIngredient(Recette recette, Ingredient ingredient, String quantite) {
        this.recette = recette;
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    public RecetteIngredientId getId() {
        return id;
    }

    public void setId(RecetteIngredientId id) {
        this.id = id;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
}
