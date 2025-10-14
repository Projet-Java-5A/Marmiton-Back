package com.epf.marmitax.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "ingredient")
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idIngredient;
    private String nomIngredient;
    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie_ingredient; // On met en snake_case pour correspondre à la BDD car ça bug sinon :(
    @ManyToMany(mappedBy = "ingredients")
    private List<Recette> recettesUsingThisIngredient;
}
