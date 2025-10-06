package com.epf.marmitax.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Ustensile {
    private Long id_ustensile_model;
    private String nom_ustensile_model;
}
