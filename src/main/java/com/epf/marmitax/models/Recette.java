package com.epf.marmitax.models;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import com.epf.marmitax.models.ApprovalStatus; //TODO fix the error

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "recette", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RecetteIngredient> recetteIngredients;

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
    private User utilisateurs;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING;
}
