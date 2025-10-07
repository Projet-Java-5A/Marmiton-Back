package com.epf.marmitax.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recette")
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecette;
    private String nomRecette;
    @ManyToMany
    @JoinTable(
        name="contenir",
        joinColumns = {@JoinColumn(name="id_recette")},
        inverseJoinColumns = {@JoinColumn(name="id_ingredient")})
    private List<Ingredient> ingredients;
    @ManyToMany
    @JoinTable(
        name="utiliser",
        joinColumns = {@JoinColumn(name="id_recette")},
        inverseJoinColumns = {@JoinColumn(name="id_ustensile")})
    private List<Ustensile> ustensiles;
    private Integer dureeRecette;
    private Integer difficulteRecette;
    private Integer prixRecette;
    private String imageRecette;
    private String contenuRecette;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
