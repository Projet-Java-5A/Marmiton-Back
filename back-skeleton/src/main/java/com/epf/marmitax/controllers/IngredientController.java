package com.epf.marmitax.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.marmitax.DTO.IngredientDto;
import com.epf.marmitax.models.Ingredient;
import com.epf.marmitax.services.IngredientService;

import java.io.IOException;

@CrossOrigin
@RequestMapping("ingredients")
@RestController
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteById(id);
    }

    @PostMapping("")
    public void addIngredient(@RequestBody IngredientDto ingredientDto) throws IOException {
        ingredientService.addIngredient(ingredientDto);
    }

    @PostMapping("/{id}")
    public void updateIngredient(@RequestBody IngredientDto ingredientDto, @PathVariable Long id) throws IOException {
        ingredientService.updateIngredient(ingredientDto, id);
    }
}
