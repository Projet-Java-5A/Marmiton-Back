package com.epf.marmitax.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.marmitax.DTO.CategorieDto;
import com.epf.marmitax.models.Categorie;
import com.epf.marmitax.services.CategorieService;

import java.io.IOException;

@CrossOrigin
@RequestMapping("categories")
@RestController
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable Long id) {
        return categorieService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieService.deleteById(id);
    }

    @PostMapping("")
    public void addCategorie(@RequestBody CategorieDto categorieDto) throws IOException {
        categorieService.addCategorie(categorieDto);
    }

    @PostMapping("/{id}")
    public void updateCategorie(@RequestBody CategorieDto categorieDto, @PathVariable Long id) throws IOException {
        categorieService.updateCategorie(categorieDto, id);
    }
}
