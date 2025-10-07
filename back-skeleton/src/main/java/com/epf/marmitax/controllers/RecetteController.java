package com.epf.marmitax.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.marmitax.DTO.RecetteDto;
import com.epf.marmitax.models.Recette;
import com.epf.marmitax.services.RecetteService;

import java.io.IOException;

@CrossOrigin
@RequestMapping("recettes")
@RestController
public class RecetteController {
    private final RecetteService recetteService;

    public RecetteController(RecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @GetMapping("/{id}")
    public Recette getRecetteById(@PathVariable Long id) {
        return recetteService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRecette(@PathVariable Long id) {
        recetteService.deleteById(id);
    }

    @PostMapping("")
    public void addRecette(@RequestBody RecetteDto recetteDto) throws IOException {
        recetteService.addRecette(recetteDto);
    }

    @PostMapping("/{id}")
    public void updateRecette(@RequestBody RecetteDto recetteDto, @PathVariable Long id) throws IOException {
        recetteService.updateRecette(recetteDto, id);
    }
}
