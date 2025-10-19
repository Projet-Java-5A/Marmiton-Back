package com.epf.marmitax.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epf.marmitax.DTO.RecetteCreateDTO;
import com.epf.marmitax.DTO.RecetteDto;
import com.epf.marmitax.services.RecetteService;

import java.util.List;

@CrossOrigin
@RequestMapping("recettes")
@RestController
public class RecetteController {
    private final RecetteService recetteService;

    public RecetteController(RecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllIngredients() {
        try {
            List<RecetteDto> recettes = recetteService.findAll();
            return new ResponseEntity<>(recettes, HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la récupération des recettes : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecetteById(@PathVariable Long id) {
        try {
            RecetteDto recette = recetteService.getById(id);
            return new ResponseEntity<>(recette, HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la récupération de la recette : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecette(@PathVariable Long id) {
        try {
            recetteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la suppression de la recette : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addRecette(@RequestBody RecetteCreateDTO recetteCreateDTO) {
        try {
            recetteService.createRecette(recetteCreateDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la création de la recette : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateRecette(@RequestBody RecetteDto recetteDto, @PathVariable Long id) {
        try {
            recetteService.updateRecette(recetteDto, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la modification de la recette : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
