package com.epf.marmitax.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categorie")
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategorieModel;
    private String nomCategorieModel;
    @OneToMany(mappedBy = "id_categorie_model")
    private List<Ingredient> ingredientsDansCategorieModel;
}
