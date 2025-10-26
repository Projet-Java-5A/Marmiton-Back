package com.epf.marmitax.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ustensile")
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Ustensile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUstensile;
    private String nomUstensile;
    @ManyToMany(mappedBy = "ustensiles")
    private List<Recette> recettesUsingThisUstensile;
}
