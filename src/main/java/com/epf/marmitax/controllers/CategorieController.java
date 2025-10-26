package com.epf.marmitax.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epf.marmitax.DTO.CategorieSimpleDto;
import com.epf.marmitax.DTO.CategorieDto;
import com.epf.marmitax.services.CategorieService;

import java.util.List;

@CrossOrigin
@RequestMapping("categories")
@RestController
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategories() {
        try{
            List<CategorieDto> categories = categorieService.findAll();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
        catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la récupération des catégories : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategorieById(@PathVariable Long id) {
        try{
            CategorieSimpleDto categorie = categorieService.getById(id);
            return new ResponseEntity<>(categorie, HttpStatus.OK);
        }
        catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la récupération de la catégorie : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable Long id) {
        try {
            categorieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la suppression de la catégorie : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addCategorie(@RequestBody CategorieSimpleDto categorieDto) {
        try {
            categorieService.addCategorie(categorieDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la création de la catégorie : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCategorie(@RequestBody CategorieSimpleDto categorieDto, @PathVariable Long id) {
        try {
            categorieService.updateCategorie(categorieDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la modification de la catégorie : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
